package com.kirby.lookthis.store.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.dto.StoreDto;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.store.service.StoreService;
import com.kirby.lookthis.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StoreController {

    private final StoreService storeService;
    private final AmazonS3Client amazonS3Client;

    private String S3Bucket = "lookthis";

    @PutMapping(value = "store/saveStore", produces = "application/json")
    public Integer insertStore(@RequestBody StoreDto storeDto) {
        storeDto.setAuthStatus(true);
        Integer storeId = storeService.insertStore(storeDto);
        if(storeId == null){
            return 0;
        }
       return storeId;
    }

    @PutMapping(value = "store/saveFlyer", consumes = {"multipart/form-data"})
    public Integer insertFlyer(@ModelAttribute FlyerDto flyerDto, @ModelAttribute MultipartFile flyerFile) throws IOException {

        String uuid = UUID.randomUUID().toString();

        Integer storeId = flyerDto.getStoreId();

        String flyerName = flyerFile.getOriginalFilename();
        Integer year = LocalDate.now().getYear();
        String day = LocalDate.now().getMonthValue() + "" + LocalDate.now().getDayOfMonth();
        String path = "/" + storeId + "/" + year + "/" + day + "/lookthis_"+ uuid + "_" + flyerName;
        flyerDto.setPath(path);
        Integer flyerId = storeService.insertFlyer(flyerDto);

        if(flyerId == null){
            return 0;
        }

        long size = flyerFile.getSize();
        ObjectMetadata objectMetaData = new ObjectMetadata();
        objectMetaData.setContentType(flyerFile.getContentType());
        objectMetaData.setContentLength(size);

        String awsPath ="flyer/image" + path;
        amazonS3Client.putObject(
                new PutObjectRequest(S3Bucket, awsPath, flyerFile.getInputStream(), objectMetaData)
                        .withCannedAcl(CannedAccessControlList.PublicRead)
        );

        return flyerId;
    }

    @PutMapping(value = "store/insertFlyerSpot", produces = "application/json")
    public void insertFlyerSpot(@RequestBody FlyerSpotDto flyerSpotDto) {
        storeService.insertFlyerSpot(flyerSpotDto);
    }

    @PostMapping(value = "store/getStoreFlyerList", produces = "application/json")
    public List<Flyer> getStoreFlyerList(@RequestBody StoreDto storeDto){

        return storeService.getStoreFlyerList(storeDto);
    }

    @PostMapping(value = "store/getStoreList", produces = "application/json")
    public List<Store> getStoreList(@RequestBody UserDto userDto){

        return storeService.getStoreList(userDto);
    }

    @PostMapping(value = "store/getFlyerSpotList", produces = "application/json")
    public List<Spot> getFlyer(@RequestBody FlyerDto flyerDto){
        return storeService.getFlyerSpotList(flyerDto);
    }

    @PostMapping(value = "store/deleteFlyerSpot", produces = "application/json")
    public String deleteFlyerSpot(@RequestBody FlyerSpotDto flyerSpotDto){
        return storeService.deleteFlyerSpot(flyerSpotDto);
    }

}

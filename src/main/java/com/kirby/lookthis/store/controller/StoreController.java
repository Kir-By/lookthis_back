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

    @PutMapping(value = "store", produces = "application/json")
    public Integer insertStore(@RequestBody StoreDto storeDto) {
        storeDto.setAuthStatus(true);
        Integer storeId = storeService.insertStore(storeDto);
        if(storeId == null){
            return 0;
        }
        return storeId;
    }

    @GetMapping(value = "store/{storeId}/flyers", produces = "application/json")
    public List<Flyer> getStoreFlyerList(@PathVariable("storeId") Integer storeId){
        StoreDto storeDto = StoreDto.builder()
                .storeId(storeId)
                .build();
        return storeService.getStoreFlyerList(storeDto);
    }

    @GetMapping(value = "store/user/{userId}", produces = "application/json")
    public List<Store> getStoreList(@PathVariable("userId") String userId){
        UserDto userDto = UserDto.builder().userId(userId).build();

        return storeService.getStoreList(userDto);
    }

}

package com.kirby.lookthis.spot.service;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.user.entity.PointHistory;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.user.repository.PointHistoryRepository;
import com.kirby.lookthis.spot.repository.SpotRepository;
import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.entity.FlyerSpot;
import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.store.entity.UserFlyer;
import com.kirby.lookthis.store.repository.FlyerRepository;
import com.kirby.lookthis.store.repository.FlyerSpotRepository;
import com.kirby.lookthis.store.repository.StoreRepository;
import com.kirby.lookthis.store.repository.UserFlyerRepository;
import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.User;
import com.kirby.lookthis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService{

    private final SpotRepository spotRepository;
    private final StoreRepository storeRepository;
    private final FlyerRepository flyerRepository;
    private final UserRepository userRepository;
    private final UserFlyerRepository userFlyerRepository;
    private final FlyerSpotRepository flyerSpotRepository;
    private final PointHistoryRepository pointHistoryRepository;

    @Override
    public List<FlyerDto> getFlyerList(SpotDto spotDto) {
        List<Integer> spotList = spotRepository.getSpotListBySpotDto(spotDto);

        return flyerRepository.findFlyerBySpots(spotList, spotDto.getUserId());
    }

    @Override
    public List<FlyerDto> getFlyerHistoryList(SpotDto spotDto) {
        return flyerRepository.findFlyerHistoryBySpots(spotDto.getUserId());
    }

    @Override
    public List<Spot> getSpotList() {
        return spotRepository.findAll();
    }

    @Override
    @Transactional
    public String insertPoint(PointDto pointDto) {
        UserDto userDto = new UserDto();
        userDto.setUserId(pointDto.userId);
        User user = userRepository.findByUserId(userDto.getUserId());
        userDto.setPoint(user.getPoint() + pointDto.getPoint());
        userRepository.updatePoint(userDto);

        Integer flyerSpotId = flyerSpotRepository.getFlyerSpotId(pointDto);

        pointDto.setFlyerSpotId(flyerSpotId);

        FlyerSpot flyerSpot = FlyerSpot.builder()
                .flyerSpotId(pointDto.flyerSpotId)
                .build();

        UserFlyer userFlyer = UserFlyer.builder()
                .user(user)
                .flyerSpot(flyerSpot)
                .build();

        Store store = storeRepository.getStoreByFlyerId(pointDto.flyerId);

        PointHistory pointHistory = PointHistory.builder()
                .flyerId(pointDto.flyerId)
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .spotId(pointDto.spotId)
                .spotName(spotRepository.findSpotBySpotId(pointDto.spotId).getStation())
                .point(pointDto.point)
                .status(1)
                .user_id(pointDto.getUserId())
                .build();

        userFlyerRepository.save(userFlyer);
        pointHistoryRepository.save(pointHistory);

        return "Success";
    }
}

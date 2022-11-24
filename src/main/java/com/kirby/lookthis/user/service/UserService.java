package com.kirby.lookthis.user.service;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.PointHistory;
import com.kirby.lookthis.user.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);
    UserDto getUser(UserDto userDto);

    void updatePoint(UserDto userDto);
    List<PointHistory> getPointHistoryList(PointDto pointDto);
    String saveFcmToken(UserDto userDto);

    default UserDto userEntityToDto(User user){
        UserDto dto = UserDto.builder()
                .userId(user.getUserId())
                .accesstoken(user.getAccesstoken())
                .auth(user.getAuth())
                .birth(user.getBirth())
                .createDate(user.getCreateDate())
                .name(user.getName())
                .password(user.getPassword())
                .phone(user.getPhone())
                .plateformtype(user.getPlateformtype())
                .point(user.getPoint())
                .updateDate(user.getUpdateDate())
                .fcmToken(user.getFcmToken())
                .build();
        return dto;
    }

    default User userDtoToEntity(UserDto userDto){
        User user = User.builder()
                .accesstoken(userDto.getAccesstoken())
                .auth(userDto.getAuth())
                .birth(userDto.getBirth())
                .createDate(userDto.getCreateDate())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .phone(userDto.getPhone())
                .plateformtype(userDto.getPlateformtype())
                .point(userDto.getPoint())
                .updateDate(userDto.getUpdateDate())
                .userId(userDto.getUserId())
                .fcmToken(userDto.getFcmToken())
                .build();

        return user;
    }
}

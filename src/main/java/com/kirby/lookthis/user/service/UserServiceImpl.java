package com.kirby.lookthis.user.service;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.PointHistory;
import com.kirby.lookthis.user.entity.User;
import com.kirby.lookthis.user.repository.PointHistoryRepository;
import com.kirby.lookthis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PointHistoryRepository pointHistoryRepository;

    @Override
    public void saveUser(UserDto userDto) {
        User user = userDtoToEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public User getUser(UserDto userDto) {
        return userRepository.findByUserId(userDto.getUserId());
    }

    @Override
    public void updatePoint(UserDto userDto) {
        userRepository.updatePoint(userDto);
    }

    @Override
    public List<PointHistory> getPointHistoryList(PointDto pointDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        LocalDateTime searchDate = LocalDateTime.parse(pointDto.searchDate+" 00", formatter);
        return pointHistoryRepository.getPointHistoryList(pointDto.userId, searchDate);
    }
}

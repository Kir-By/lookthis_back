package com.kirby.lookthis.user.service;

import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.User;
import com.kirby.lookthis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

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
}

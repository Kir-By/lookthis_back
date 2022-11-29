package com.kirby.lookthis.main.service;

import com.kirby.lookthis.main.entity.SystemError;
import com.kirby.lookthis.main.repository.SystemErrorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class SystemErrorServiceImpl implements SystemErrorService {
    private final SystemErrorRepository systemErrorRepository;

    @Override
    public void saveError(SystemError systemError) {
        systemErrorRepository.save(systemError);
    }
}

package com.kirby.lookthis.user.repository;

import com.kirby.lookthis.user.entity.PointHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PointHistoryRepository extends JpaRepository<PointHistory, Integer> {

    @Query("select ph from PointHistory ph " +
            "where ph.user_id = :userId " +
            "and ph.createDate > :searchDate order by ph.createDate desc ")
    List<PointHistory> getPointHistoryList(String userId,  LocalDateTime searchDate);

}

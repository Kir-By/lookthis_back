package com.kirby.lookthis.main.repository;

import com.kirby.lookthis.main.entity.AwsInfo;
import com.kirby.lookthis.store.entity.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AwsInfoRepository extends CrudRepository<AwsInfo, String > {

    AwsInfo getAwsInfoByAwsInfoId(Integer awsInfoId);
}

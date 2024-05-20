package com.tst.cosmosTest.infra.repository;

import com.tst.cosmosTest.domain.entity.EventMonitor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventMonitorRepository extends MongoRepository<EventMonitor, String> {

    EventMonitor findByIdAndWalletAddress(String Id, String walletAddress);

    List<EventMonitor> findAllByWalletAddress(String walletAddress);
}

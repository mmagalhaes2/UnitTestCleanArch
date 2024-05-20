package com.tst.cosmosTest.infra.repository;

import com.tst.cosmosTest.domain.entity.TransactionMonitor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionMonitorRepository extends MongoRepository<TransactionMonitor, String> {

    TransactionMonitor findByIdAndWalletAddress(String Id, String walletAddress);

    List<TransactionMonitor> findByWalletAddress(String walletAddress);
}

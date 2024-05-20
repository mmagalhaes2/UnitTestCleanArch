package com.tst.cosmosTest.domain;

import com.tst.cosmosTest.domain.entity.TransactionMonitor;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionMonitorProvider {
    @Transactional(rollbackFor = Exception.class)
    TransactionMonitor registerMonitor(TransactionMonitor transactionMonitor) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    void deleteMonitor(String id) throws Exception;
}

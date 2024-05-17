package com.tst.cosmosTest.infra.dataprovider;

import com.tst.cosmosTest.domain.TransactionMonitorProvider;
import com.tst.cosmosTest.domain.entity.TransactionMonitor;
import com.tst.cosmosTest.infra.repository.TransactionMonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TransactionMonitorProviderImpl implements TransactionMonitorProvider {

    private final TransactionMonitorRepository transactionMonitorRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransactionMonitor registerMonitor(TransactionMonitor transactionMonitor) throws Exception {
        return transactionMonitorRepository.save(transactionMonitor);
    }
}

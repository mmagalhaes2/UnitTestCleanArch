package com.tst.cosmosTest.domain.usecase.transactionEventsMonitor;

import com.tst.cosmosTest.domain.TransactionMonitorProvider;
import com.tst.cosmosTest.domain.entity.TransactionMonitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterTransactionMonitorUseCase {
    private final TransactionMonitorProvider transactionMonitorProvider;

    public TransactionMonitor execute(TransactionMonitor transactionMonitor) {
        validateFields(transactionMonitor);
        try {
            return transactionMonitorProvider.registerMonitor(transactionMonitor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void validateFields(TransactionMonitor transactionMonitor) {
        if (transactionMonitor.getType() == null) {
            throw new IllegalArgumentException("Transaction type is required");
        }
        if (transactionMonitor.getTransactionHash() == null) {
            throw new IllegalArgumentException("Transaction hash is required");
        }
        if (transactionMonitor.getCallbackUrl() == null) {
            throw new IllegalArgumentException("Callback URL is required");
        }
    }
}

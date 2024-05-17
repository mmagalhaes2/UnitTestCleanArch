package com.tst.cosmosTest.app.service.impl;

import com.tst.cosmosTest.app.service.EventMonitorService;
import com.tst.cosmosTest.domain.entity.RegisterMonitor;
import com.tst.cosmosTest.domain.entity.enums.MonitorTypeEnum;
import com.tst.cosmosTest.domain.usecase.contractEventsMonitor.RegisterEventMonitorUseCase;
import com.tst.cosmosTest.domain.usecase.transactionEventsMonitor.RegisterTransactionMonitorUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventMonitorServiceImpl implements EventMonitorService {

    private final RegisterEventMonitorUseCase registerEventMonitorUseCase;
    private final RegisterTransactionMonitorUseCase registerTransactionMonitorUseCase;

    @Override
    public String registerMonitor(String walletAddress, RegisterMonitor registerMonitor) throws InterruptedException, ExecutionException {
        if (Optional.ofNullable(registerMonitor.getType()).isEmpty()) {
            throw new IllegalArgumentException("Type is required");
        }

        if (registerMonitor.getType().equals(MonitorTypeEnum.EVENT)) {
            return registerEventMonitorUseCase.execute(registerMonitor.getParameters().getEventMonitor()).getId();
        } else if (registerMonitor.getType().equals(MonitorTypeEnum.TRANSACTION)) {
            return registerTransactionMonitorUseCase.execute(registerMonitor.getParameters().getTransactionMonitor()).getId();
        } else {
            throw new IllegalArgumentException("Type not found");
        }
    }
}

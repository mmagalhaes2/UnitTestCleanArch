package com.tst.cosmosTest.app.service;

import com.tst.cosmosTest.app.service.impl.EventMonitorServiceImpl;
import com.tst.cosmosTest.domain.entity.EventMonitor;
import com.tst.cosmosTest.domain.entity.MonitorParameters;
import com.tst.cosmosTest.domain.entity.RegisterMonitor;
import com.tst.cosmosTest.domain.entity.TransactionMonitor;
import com.tst.cosmosTest.domain.entity.enums.MonitorTypeEnum;
import com.tst.cosmosTest.domain.usecase.contractEventsMonitor.RegisterEventMonitorUseCase;
import com.tst.cosmosTest.domain.usecase.transactionEventsMonitor.RegisterTransactionMonitorUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EventMonitorServiceImplTest {

    @Mock
    private RegisterEventMonitorUseCase registerEventMonitorUseCase;

    @Mock
    private RegisterTransactionMonitorUseCase registerTransactionMonitorUseCase;

    @InjectMocks
    private EventMonitorServiceImpl eventMonitorServiceImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should register event monitor successfully")
    public void shouldRegisterEventMonitorSuccessfully() throws ExecutionException, InterruptedException {
        RegisterMonitor registerMonitor = new RegisterMonitor();
        registerMonitor.setType(MonitorTypeEnum.EVENT);
        registerMonitor.setParameters(new MonitorParameters());
        when(registerEventMonitorUseCase.execute(any())).thenReturn(new EventMonitor().builder().id("123").build());

        String result = eventMonitorServiceImpl.registerMonitor("testWalletAddress", registerMonitor);

        assertEquals("123", result);
    }

    @Test
    @DisplayName("Should register transaction monitor successfully")
    public void shouldRegisterTransactionMonitorSuccessfully() throws ExecutionException, InterruptedException {
        RegisterMonitor registerMonitor = new RegisterMonitor();
        registerMonitor.setType(MonitorTypeEnum.TRANSACTION);
        registerMonitor.setParameters(new MonitorParameters());
        when(registerTransactionMonitorUseCase.execute(any())).thenReturn(new TransactionMonitor().builder().id("123").build());

        String result = eventMonitorServiceImpl.registerMonitor("testWalletAddress", registerMonitor);

        assertEquals("123", result);
    }

    @Test
    @DisplayName("Should fail to register monitor when type is missing")
    public void shouldFailToRegisterMonitorWhenTypeIsMissing() {
        RegisterMonitor registerMonitor = new RegisterMonitor();

        assertThrows(IllegalArgumentException.class, () -> eventMonitorServiceImpl.registerMonitor("testWalletAddress", registerMonitor));
    }

//    @Test
//    @DisplayName("Should fail to register monitor when type is not found")
//    public void shouldFailToRegisterMonitorWhenTypeIsNotFound() {
//        RegisterMonitor registerMonitor = new RegisterMonitor();
//        registerMonitor.setType(MonitorTypeEnum.valueOf("TEST"));
//
//        assertThrows(IllegalArgumentException.class, () -> eventMonitorServiceImpl.registerMonitor("testWalletAddress", registerMonitor));
//    }
}

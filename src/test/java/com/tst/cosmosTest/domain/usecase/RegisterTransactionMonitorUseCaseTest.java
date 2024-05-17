package com.tst.cosmosTest.domain.usecase;

import com.tst.cosmosTest.domain.TransactionMonitorProvider;
import com.tst.cosmosTest.domain.entity.TransactionMonitor;
import com.tst.cosmosTest.domain.entity.enums.TransactionTypeEnum;
import com.tst.cosmosTest.domain.usecase.transactionEventsMonitor.RegisterTransactionMonitorUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RegisterTransactionMonitorUseCaseTest {

    @Mock
    private TransactionMonitorProvider transactionMonitorProvider;

    @InjectMocks
    private RegisterTransactionMonitorUseCase registerTransactionMonitorUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should register transaction monitor successfully")
    public void shouldRegisterTransactionMonitorSuccessfully() throws Exception {
        TransactionMonitor transactionMonitor = new TransactionMonitor();
        transactionMonitor.setType(TransactionTypeEnum.HASH);
        transactionMonitor.setTransactionHash("testTransactionHash");
        transactionMonitor.setCallbackUrl("callbackUrl");
        when(transactionMonitorProvider.registerMonitor(any())).thenReturn(transactionMonitor);

        registerTransactionMonitorUseCase.execute(transactionMonitor);
    }

    @Test
    @DisplayName("Should fail to register transaction monitor when type is missing")
    public void shouldFailToRegisterTransactionMonitorWhenTypeIsMissing() {
        TransactionMonitor transactionMonitor = new TransactionMonitor();
        transactionMonitor.setTransactionHash("testTransactionHash");
        transactionMonitor.setCallbackUrl("callbackUrl");

        assertThrows(IllegalArgumentException.class, () -> registerTransactionMonitorUseCase.execute(transactionMonitor));
    }

    @Test
    @DisplayName("Should fail to register transaction monitor when transaction hash is missing")
    public void shouldFailToRegisterTransactionMonitorWhenTransactionHashIsMissing() {
        TransactionMonitor transactionMonitor = new TransactionMonitor();
        transactionMonitor.setType(TransactionTypeEnum.HASH);
        transactionMonitor.setCallbackUrl("callbackUrl");

        assertThrows(IllegalArgumentException.class, () -> registerTransactionMonitorUseCase.execute(transactionMonitor));
    }

    @Test
    @DisplayName("Should fail to register transaction monitor when callback URL is missing")
    public void shouldFailToRegisterTransactionMonitorWhenCallbackURLIsMissing() {
        TransactionMonitor transactionMonitor = new TransactionMonitor();
        transactionMonitor.setType(TransactionTypeEnum.HASH);
        transactionMonitor.setTransactionHash("testTransactionHash");

        assertThrows(IllegalArgumentException.class, () -> registerTransactionMonitorUseCase.execute(transactionMonitor));
    }
}

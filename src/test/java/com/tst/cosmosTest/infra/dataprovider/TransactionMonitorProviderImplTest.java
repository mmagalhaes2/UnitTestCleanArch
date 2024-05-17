package com.tst.cosmosTest.infra.dataprovider;

import com.tst.cosmosTest.domain.entity.TransactionMonitor;
import com.tst.cosmosTest.infra.repository.TransactionMonitorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TransactionMonitorProviderImplTest {

    @Mock
    private TransactionMonitorRepository transactionMonitorRepository;

    @InjectMocks
    private TransactionMonitorProviderImpl transactionMonitorProviderImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should register transaction monitor successfully")
    public void shouldRegisterTransactionMonitorSuccessfully() throws Exception {
        TransactionMonitor transactionMonitor = new TransactionMonitor();
        when(transactionMonitorRepository.save(any())).thenReturn(transactionMonitor);

        TransactionMonitor result = transactionMonitorProviderImpl.registerMonitor(transactionMonitor);

        assertNotNull(result);
    }

    @Test
    @DisplayName("Should fail to register transaction monitor when repository throws exception")
    public void shouldFailToRegisterTransactionMonitorWhenRepositoryThrowsException() throws Exception {
        TransactionMonitor transactionMonitor = new TransactionMonitor();
        when(transactionMonitorRepository.save(any())).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> transactionMonitorProviderImpl.registerMonitor(transactionMonitor));
    }
}

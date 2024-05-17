package com.tst.cosmosTest.infra.dataprovider;

import com.tst.cosmosTest.domain.entity.EventMonitor;
import com.tst.cosmosTest.infra.repository.EventMonitorRepository;
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

public class EventMonitorProviderImplTest {

    @Mock
    private EventMonitorRepository eventMonitorRepository;

    @InjectMocks
    private EventMonitorProviderImpl eventMonitorProviderImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should register event monitor successfully")
    public void shouldRegisterEventMonitorSuccessfully() throws Exception {
        EventMonitor eventMonitor = new EventMonitor();
        when(eventMonitorRepository.save(any())).thenReturn(eventMonitor);

        EventMonitor result = eventMonitorProviderImpl.registerMonitor(eventMonitor);

        assertNotNull(result);
    }

    @Test
    @DisplayName("Should fail to register event monitor when repository throws exception")
    public void shouldFailToRegisterEventMonitorWhenRepositoryThrowsException() throws Exception {
        EventMonitor eventMonitor = new EventMonitor();
        when(eventMonitorRepository.save(any())).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> eventMonitorProviderImpl.registerMonitor(eventMonitor));
    }
}

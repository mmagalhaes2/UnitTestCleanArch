package com.tst.cosmosTest.domain.usecase;

import com.tst.cosmosTest.domain.EventMonitorProvider;
import com.tst.cosmosTest.domain.entity.EventMonitor;
import com.tst.cosmosTest.domain.entity.EventSpecification;
import com.tst.cosmosTest.domain.usecase.contractEventsMonitor.RegisterEventMonitorUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RegisterEventMonitorUseCaseTest {

    @Mock
    private EventMonitorProvider eventMonitorProvider;

    @InjectMocks
    private RegisterEventMonitorUseCase registerEventMonitorUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should register event monitor successfully")
    public void shouldRegisterEventMonitorSuccessfully() throws Exception {
        EventMonitor eventMonitor = new EventMonitor();
        eventMonitor.setContractAddress("testContractAddress");
        eventMonitor.setEventSpecification(new EventSpecification("eventName", null));
        eventMonitor.setCallbackUrl("callbackUrl");
        when(eventMonitorProvider.registerMonitor(any())).thenReturn(eventMonitor);

        registerEventMonitorUseCase.execute(eventMonitor);
    }

    @Test
    @DisplayName("Should fail to register event monitor when contract address is missing")
    public void shouldFailToRegisterEventMonitorWhenContractAddressIsMissing() {
        EventMonitor eventMonitor = new EventMonitor();
        eventMonitor.setEventSpecification(new EventSpecification("eventName", null));
        eventMonitor.setCallbackUrl("callbackUrl");

        assertThrows(IllegalArgumentException.class, () -> registerEventMonitorUseCase.execute(eventMonitor));
    }

    @Test
    @DisplayName("Should fail to register event monitor when event name is missing")
    public void shouldFailToRegisterEventMonitorWhenEventNameIsMissing() {
        EventMonitor eventMonitor = new EventMonitor();
        eventMonitor.setContractAddress("testContractAddress");
        eventMonitor.setEventSpecification(new EventSpecification());
        eventMonitor.setCallbackUrl("callbackUrl");

        assertThrows(IllegalArgumentException.class, () -> registerEventMonitorUseCase.execute(eventMonitor));
    }

    @Test
    @DisplayName("Should fail to register event monitor when callback URL is missing")
    public void shouldFailToRegisterEventMonitorWhenCallbackURLIsMissing() {
        EventMonitor eventMonitor = new EventMonitor();
        eventMonitor.setContractAddress("testContractAddress");
        eventMonitor.setEventSpecification(new EventSpecification("eventName", null));

        assertThrows(IllegalArgumentException.class, () -> registerEventMonitorUseCase.execute(eventMonitor));
    }
}

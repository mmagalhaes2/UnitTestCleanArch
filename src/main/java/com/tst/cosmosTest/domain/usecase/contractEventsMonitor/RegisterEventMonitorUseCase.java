package com.tst.cosmosTest.domain.usecase.contractEventsMonitor;

import com.tst.cosmosTest.domain.EventMonitorProvider;
import com.tst.cosmosTest.domain.entity.EventMonitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterEventMonitorUseCase {

    private final EventMonitorProvider eventMonitorProvider;

    public EventMonitor execute(EventMonitor eventMonitor) {
        validateFields(eventMonitor);
        try {
            return eventMonitorProvider.registerMonitor(eventMonitor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void validateFields(EventMonitor eventMonitor) {
        if (eventMonitor.getContractAddress() == null) {
            throw new IllegalArgumentException("Contract address is required");
        }
        if (eventMonitor.getEventSpecification().getName() == null) {
            throw new IllegalArgumentException("Event name is required");
        }
        if (eventMonitor.getCallbackUrl() == null) {
            throw new IllegalArgumentException("Callback URL is required");
        }
    }

}

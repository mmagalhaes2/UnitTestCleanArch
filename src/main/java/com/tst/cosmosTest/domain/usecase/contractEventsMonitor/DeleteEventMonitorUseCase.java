package com.tst.cosmosTest.domain.usecase.contractEventsMonitor;

import com.tst.cosmosTest.domain.EventMonitorProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteEventMonitorUseCase {

    private final EventMonitorProvider eventMonitorProvider;

    public void deleteEventMonitor(String id, String walletAddress) throws Exception {
        try {
            eventMonitorProvider.deleteMonitor(id);
        } catch (Exception e) {
            throw new Exception("Error deleting event monitor", e);
        }
    }
}

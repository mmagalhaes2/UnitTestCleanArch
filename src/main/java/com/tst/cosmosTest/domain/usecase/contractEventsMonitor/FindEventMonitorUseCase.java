package com.tst.cosmosTest.domain.usecase.contractEventsMonitor;

import com.tst.cosmosTest.domain.EventMonitorProvider;
import com.tst.cosmosTest.domain.entity.EventMonitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindEventMonitorUseCase {
    private final EventMonitorProvider eventMonitorProvider;

    public EventMonitor findEventMonitor(String id, String walletAddress) throws Exception {
        try {
            return eventMonitorProvider.findEventMonitor(id, walletAddress);
        } catch (Exception e) {
            throw new Exception("Error finding event monitor", e);
        }
    }

    public List<EventMonitor> findEventMonitors(String walletAddress) throws Exception {
        try {
            return eventMonitorProvider.findEventMonitors(walletAddress);
        } catch (Exception e) {
            throw new Exception("Error finding event monitors", e);
        }
    }
}

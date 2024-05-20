package com.tst.cosmosTest.infra.dataprovider;

import com.tst.cosmosTest.domain.EventMonitorProvider;
import com.tst.cosmosTest.domain.entity.EventMonitor;
import com.tst.cosmosTest.infra.repository.EventMonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventMonitorProviderImpl implements EventMonitorProvider {
    private final EventMonitorRepository eventMonitorRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EventMonitor registerMonitor(EventMonitor eventMonitor) throws Exception {
        return eventMonitorRepository.save(eventMonitor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMonitor(String id) throws Exception {
        try {
            eventMonitorRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Error deleting monitor");
        }
    }

    @Override
    public EventMonitor findEventMonitor(String id, String walletAddress) throws Exception {
        try {
            return eventMonitorRepository.findByIdAndWalletAddress(id, walletAddress);
        } catch (Exception e) {
            throw new Exception("Error finding event monitor", e);
        }
    }

    @Override
    public List<EventMonitor> findEventMonitors(String walletAddress) throws Exception {
        try {
            return eventMonitorRepository.findAllByWalletAddress(walletAddress);
        } catch (Exception e) {
            throw new Exception("Error finding event monitors", e);
        }
    }
}

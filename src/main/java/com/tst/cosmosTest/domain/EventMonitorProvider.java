package com.tst.cosmosTest.domain;

import com.tst.cosmosTest.domain.entity.EventMonitor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EventMonitorProvider {

    EventMonitor findEventMonitor(String id, String walletAddress) throws Exception;

    List<EventMonitor> findEventMonitors(String walletAddress) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    EventMonitor registerMonitor(EventMonitor eventMonitor) throws Exception;

    @Transactional(rollbackFor = Exception.class)
    void deleteMonitor(String id) throws Exception;
}

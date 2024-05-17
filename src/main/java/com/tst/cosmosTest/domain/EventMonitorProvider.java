package com.tst.cosmosTest.domain;

import com.tst.cosmosTest.domain.entity.EventMonitor;
import org.springframework.transaction.annotation.Transactional;

public interface EventMonitorProvider {

    @Transactional(rollbackFor = Exception.class)
    EventMonitor registerMonitor(EventMonitor eventMonitor) throws Exception;
}

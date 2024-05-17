package com.tst.cosmosTest.infra.dataprovider;

import com.tst.cosmosTest.domain.EventMonitorProvider;
import com.tst.cosmosTest.domain.entity.EventMonitor;
import com.tst.cosmosTest.infra.repository.EventMonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class EventMonitorProviderImpl implements EventMonitorProvider {
    private final EventMonitorRepository eventMonitorRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EventMonitor registerMonitor(EventMonitor eventMonitor) throws Exception {
        return eventMonitorRepository.save(eventMonitor);
    }
}

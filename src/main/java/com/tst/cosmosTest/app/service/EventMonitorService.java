package com.tst.cosmosTest.app.service;

import com.tst.cosmosTest.domain.entity.EventMonitor;
import com.tst.cosmosTest.domain.entity.RegisterMonitor;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface EventMonitorService {
    List<EventMonitor> getMonitors(String walletAddress) throws Exception;

    EventMonitor getMonitor(String id, String walletAddress) throws Exception;

    String registerMonitor(String walletAddress, RegisterMonitor registerMonitor) throws InterruptedException, ExecutionException;

    void deleteMonitor(String id, String walletAddress) throws Exception;
}

package com.tst.cosmosTest.app.service;

import com.tst.cosmosTest.domain.entity.EventMonitor;
import com.tst.cosmosTest.domain.entity.RegisterMonitor;

import java.util.concurrent.ExecutionException;

public interface EventMonitorService {
    String registerMonitor(String walletAddress, RegisterMonitor registerMonitor) throws InterruptedException, ExecutionException;
}

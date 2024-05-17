package com.tst.cosmosTest.app.resource;

import com.tst.cosmosTest.app.service.EventMonitorService;
import com.tst.cosmosTest.domain.entity.RegisterMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class EventMonitorController {

    private final EventMonitorService eventMonitorService;

    @Autowired
    public EventMonitorController(EventMonitorService eventMonitorService) {
        this.eventMonitorService = eventMonitorService;
    }

    @PostMapping("/event-monitor")
    public @ResponseBody String createEventMonitor(@RequestHeader(value = "wallet-address") String walletAddress, @RequestBody RegisterMonitor registerMonitor) throws ExecutionException, InterruptedException {
        return eventMonitorService.registerMonitor(walletAddress, registerMonitor);
    }

}

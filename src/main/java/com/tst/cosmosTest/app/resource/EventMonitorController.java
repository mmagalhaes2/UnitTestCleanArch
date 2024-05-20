package com.tst.cosmosTest.app.resource;

import com.tst.cosmosTest.app.service.EventMonitorService;
import com.tst.cosmosTest.domain.entity.EventMonitor;
import com.tst.cosmosTest.domain.entity.RegisterMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class EventMonitorController {

    private final EventMonitorService eventMonitorService;

    @Autowired
    public EventMonitorController(EventMonitorService eventMonitorService) {
        this.eventMonitorService = eventMonitorService;
    }

    @GetMapping("/event-monitor")
    public @ResponseBody List<EventMonitor> getEventMonitors(@RequestHeader(value = "wallet-address") String walletAddress) throws Exception {
        return eventMonitorService.getMonitors(walletAddress);
    }

    @GetMapping("/event-monitor/{id}")
    public @ResponseBody ResponseEntity<EventMonitor> getEventMonitor(@RequestHeader(value = "wallet-address") String walletAddress, @PathVariable String id) throws Exception {
//        return eventMonitorService.getMonitor(id, walletAddress);
        EventMonitor eventMonitor = eventMonitorService.getMonitor(id, walletAddress);
        if (Optional.ofNullable(eventMonitor).isPresent()) {
            return ResponseEntity.ok(eventMonitor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/event-monitor")
    public @ResponseBody String createEventMonitor(@RequestHeader(value = "wallet-address") String walletAddress, @RequestBody RegisterMonitor registerMonitor) throws ExecutionException, InterruptedException {
        return eventMonitorService.registerMonitor(walletAddress, registerMonitor);
    }

    @DeleteMapping("/event-monitor/{id}")
    public void deleteEventMonitor(@RequestHeader(value = "wallet-address") String walletAddress, @PathVariable String id) throws Exception {
        eventMonitorService.deleteMonitor(id, walletAddress);
    }

}

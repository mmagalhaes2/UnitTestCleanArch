//package com.tst.cosmosTest.app.resource;
//
//import com.tst.cosmosTest.app.service.EventMonitorService;
//import com.tst.cosmosTest.domain.entity.RegisterMonitor;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class EventMonitorControllerTest {
//
//    @Mock
//    private EventMonitorService eventMonitorService;
//
//    @InjectMocks
//    private EventMonitorController eventMonitorController;
//
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(eventMonitorController).build();
//    }
//
//    @Test
//    @DisplayName("Should create event monitor successfully")
//    public void shouldCreateEventMonitorSuccessfully() throws Exception {
//        String walletAddress = "testWalletAddress";
//        RegisterMonitor registerMonitor = new RegisterMonitor();
//        when(eventMonitorService.registerMonitor(eq(walletAddress), any(RegisterMonitor.class))).thenReturn("Success");
//
//        mockMvc.perform(post("/api/event-monitor")
//                        .header("wallet-address", walletAddress)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @DisplayName("Should fail to create event monitor when wallet address is missing")
//    public void shouldFailToCreateEventMonitorWhenWalletAddressIsMissing() throws Exception {
//        mockMvc.perform(post("/api/event-monitor")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}"))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    @DisplayName("Should fail to create event monitor when service throws exception")
//    public void shouldFailToCreateEventMonitorWhenServiceThrowsException() throws Exception {
//        String walletAddress = "testWalletAddress";
//        RegisterMonitor registerMonitor = new RegisterMonitor();
//        when(eventMonitorService.registerMonitor(eq(walletAddress), any(RegisterMonitor.class))).thenThrow(new RuntimeException());
//
//        mockMvc.perform(post("/api/event-monitor")
//                        .header("wallet-address", walletAddress)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{}"))
//                .andExpect(status().isInternalServerError());
//    }
//}

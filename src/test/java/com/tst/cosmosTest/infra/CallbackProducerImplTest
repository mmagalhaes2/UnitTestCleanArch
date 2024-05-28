import com.google.gson.JsonObject;
import com.tst.cosmosTest.infra.callbackprovider.CallbackProducerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CallbackProducerImplTest {

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.RequestBodySpec requestBodySpec;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;

    @Mock
    private WebClient webClient;

    @InjectMocks
    private CallbackProducerImpl callbackProducerImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.contentType(any(MediaType.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.body(any())).thenReturn(requestHeadersSpec);
    }

    @Test
    @DisplayName("Should send callback successfully")
    public void shouldSendCallbackSuccessfully() {
        JsonObject jsonObject = new JsonObject();
        callbackProducerImpl.callbackFromUrl(jsonObject);

        verify(webClient, times(1)).post();
        verify(requestBodyUriSpec, times(1)).uri(anyString());
        verify(requestBodySpec, times(1)).contentType(any(MediaType.class));
        verify(requestBodySpec, times(1)).body(any());
    }
}

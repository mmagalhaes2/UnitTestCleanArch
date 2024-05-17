package com.tst.cosmosTest.infra.config;

import com.tst.cosmosTest.infra.config.MongoConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class MongoConfigTest {

    @Mock
    private MongoDatabaseFactory mongoDatabaseFactory;

    @InjectMocks
    private MongoConfig mongoConfig;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should provide correct date time")
    public void shouldProvideCorrectDateTime() {
        LocalDateTime result = LocalDateTime.from(mongoConfig.dateTimeProvider().getNow().get());
        assertEquals(ZoneOffset.of("Z"), result.atOffset(ZoneOffset.UTC).getOffset());
    }

    @Test
    @DisplayName("Should provide transaction manager successfully")
    public void shouldProvideTransactionManagerSuccessfully() {
        when(mongoDatabaseFactory.getMongoDatabase()).thenReturn(null);
        MongoTransactionManager result = mongoConfig.transactionManager(mongoDatabaseFactory);
        assertNotNull(result);
    }
}

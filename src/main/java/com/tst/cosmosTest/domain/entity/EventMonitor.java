package com.tst.cosmosTest.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "eventMonitorData")
public class EventMonitor {

    @Id
    @Field(name = "_id")
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String walletAddress;
    private String contractAddress;
    private EventSpecification eventSpecification;
    private CorrelationStrategy correlationStrategy;
    private String callbackUrl;
}

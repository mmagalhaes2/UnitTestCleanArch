package com.tst.cosmosTest.domain.entity;

import com.tst.cosmosTest.domain.entity.enums.NotificationsStatusEnum;
import com.tst.cosmosTest.domain.entity.enums.TransactionTypeEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transactionMonitorData")
public class TransactionMonitor {

    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String id;
    private String walletAddress;
    private TransactionTypeEnum type;
    private String transactionHash;
    private String nodeName;
    private List<NotificationsStatusEnum> notificationsStatus;
    private CorrelationStrategy correlationStrategy;
    private String callbackUrl;
    private Boolean blockCreatedIndicator;
    private Boolean failedReasonIndicator;
}

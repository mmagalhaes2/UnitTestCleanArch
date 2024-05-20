package com.tst.cosmosTest.domain.entity;

import com.tst.cosmosTest.domain.entity.enums.NotificationsStatusEnum;
import com.tst.cosmosTest.domain.entity.enums.TransactionTypeEnum;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonitorParameters {
    private String contractAddress;
    private String walletAddress;
    private EventSpecification eventSpecification;
    private CorrelationStrategy correlationStrategy;
    private String callbackUrl;
    private TransactionTypeEnum transactionType;
    private String transactionHash;
    private String nodeName;
    private List<NotificationsStatusEnum> notificationsStatus;
    private Boolean blockCreatedIndicator;
    private Boolean failedReasonIndicator;

    public EventMonitor getEventMonitor() {
        return EventMonitor.builder()
                .contractAddress(contractAddress)
                .walletAddress(walletAddress)
                .eventSpecification(eventSpecification)
                .correlationStrategy(correlationStrategy)
                .callbackUrl(callbackUrl)
                .build();
    }

    public TransactionMonitor getTransactionMonitor() {
        return TransactionMonitor.builder()
                .type(transactionType)
                .walletAddress(walletAddress)
                .transactionHash(transactionHash)
                .nodeName(nodeName)
                .notificationsStatus(notificationsStatus)
                .blockCreatedIndicator(blockCreatedIndicator)
                .failedReasonIndicator(failedReasonIndicator)
                .build();
    }
}

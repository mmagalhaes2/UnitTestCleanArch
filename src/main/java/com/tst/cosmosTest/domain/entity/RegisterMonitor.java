package com.tst.cosmosTest.domain.entity;

import com.tst.cosmosTest.domain.entity.enums.MonitorTypeEnum;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMonitor {
    private MonitorTypeEnum type;
    private MonitorParameters parameters;
}

package com.tst.cosmosTest.domain.entity;

import com.tst.cosmosTest.domain.entity.enums.TypeStrategyEnum;
import lombok.*;

import static com.tst.cosmosTest.domain.entity.enums.TypeStrategyEnum.NON_INDEXED_PARAMETER;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CorrelationStrategy {
    private TypeStrategyEnum type = NON_INDEXED_PARAMETER;
    private Integer parameterIndex = 0;
}

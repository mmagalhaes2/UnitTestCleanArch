package com.tst.cosmosTest.domain.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Parameters {
    private Integer position;
    private String type;
    private Boolean isIndexed;
}

package com.tst.cosmosTest.domain.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventSpecification {
    private String name;
    private List<Parameters> parameters;
}

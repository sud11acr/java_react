package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Bill {

    private Integer id;
    private String document;
    private Customer customer;
    private Double cost;
}

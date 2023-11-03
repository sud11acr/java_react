package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Customer {

    private Integer id;
    private String name1;
    private String name2;
    private String name3;
    private Double tall;
}

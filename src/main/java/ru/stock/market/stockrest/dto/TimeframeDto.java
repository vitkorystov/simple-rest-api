package ru.stock.market.stockrest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeframeDto {

    private Integer id;

    private String name;

    private String description;

}
package ru.stock.market.stockrest.entity;

import lombok.*;
import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public class BaseTickerTimeFrameEntity extends StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;
}

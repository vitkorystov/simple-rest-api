package ru.stock.market.stockrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "stock_market_data")
@Data
public class StockDataEntity extends StockEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "start_date")
    private java.sql.Timestamp startDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticker_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private TickerEntity tickerEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timeframe_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private TimeframeEntity timeframeEntity;

    @Column(name = "open_price")
    private float openPrice;

    @Column(name = "high_price")
    private float highPrice;

    @Column(name = "low_price")
    private float lowPrice;

    @Column(name = "close_price")
    private float closePrice;

    @Column(name = "volume")
    private BigInteger volume;

}

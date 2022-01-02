package ru.stock.market.stockrest.dto;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stock.market.stockrest.entity.TickerEntity;
import ru.stock.market.stockrest.entity.TimeframeEntity;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockDataDto {

    private BigInteger id;

    private java.sql.Timestamp startDate;

    private TickerEntity tickerEntity;

    private TimeframeEntity timeframeEntity;

    private float openPrice;

    private float highPrice;

    private float lowPrice;

    private float closePrice;

    private BigInteger volume;

}

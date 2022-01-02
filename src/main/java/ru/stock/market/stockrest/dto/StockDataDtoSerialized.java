package ru.stock.market.stockrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stock.market.stockrest.entity.TickerEntity;
import ru.stock.market.stockrest.entity.TimeframeEntity;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockDataDtoSerialized {

    private BigInteger id;

    private String startDate;

    private String ticker;

    private String timeframe;

    private float openPrice;

    private float highPrice;

    private float lowPrice;

    private float closePrice;

    private BigInteger volume;

}

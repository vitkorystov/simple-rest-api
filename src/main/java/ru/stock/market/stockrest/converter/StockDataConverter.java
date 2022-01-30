package ru.stock.market.stockrest.converter;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import ru.stock.market.stockrest.dto.StockDataDto;
import ru.stock.market.stockrest.dto.StockDataDtoSerialized;
import ru.stock.market.stockrest.dto.StockDto;
import ru.stock.market.stockrest.dto.TickerDto;
import ru.stock.market.stockrest.entity.StockDataEntity;
import ru.stock.market.stockrest.entity.StockEntity;
import ru.stock.market.stockrest.entity.TickerEntity;


@Component
@Log
public class StockDataConverter extends StockConverter {

    @Override
    public void makeEntityFromDto(StockDto dto) {
        StockDataDto d = (StockDataDto) dto;
        StockDataEntity entity = new StockDataEntity();
        entity.setId(d.getId());
        entity.setStartDate(d.getStartDate());
        entity.setTickerEntity(d.getTickerEntity());
        entity.setTimeframeEntity(d.getTimeframeEntity());
        entity.setOpenPrice(d.getOpenPrice());
        entity.setHighPrice(d.getHighPrice());
        entity.setLowPrice(d.getLowPrice());
        entity.setClosePrice(d.getLowPrice());
        entity.setVolume(d.getVolume());
        setEntity(entity);
    }

    @Override
    public void makeDtoFromEntity(StockEntity se) {
        StockDataEntity e = (StockDataEntity) se;
        setDto(new StockDataDto(e.getId(),
                                e.getStartDate(),
                                e.getTickerEntity(),
                                e.getTimeframeEntity(),
                                e.getOpenPrice(),
                                e.getHighPrice(),
                                e.getLowPrice(),
                                e.getClosePrice(),
                                e.getVolume()));
    }

    public StockDataDtoSerialized makeDtoResponseFromEntity(StockDataEntity e) {
        return new StockDataDtoSerialized(e.getId(),
                e.getStartDate().toString(),
                e.getTickerEntity().getName(),
                e.getTimeframeEntity().getName(),
                e.getOpenPrice(),
                e.getHighPrice(),
                e.getLowPrice(),
                e.getClosePrice(),
                e.getVolume());
    }
}

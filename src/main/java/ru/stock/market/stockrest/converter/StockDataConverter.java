package ru.stock.market.stockrest.converter;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import ru.stock.market.stockrest.dto.StockDataDto;
import ru.stock.market.stockrest.dto.StockDataDtoSerialized;
import ru.stock.market.stockrest.entity.StockDataEntity;

@Component
@Log
public class StockDataConverter extends BaseConverter<StockDataEntity, StockDataDto>{

    @Override
    public StockDataEntity makeEntityFromDto(StockDataDto d) {
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
        return entity;
    }

    @Override
    public StockDataDto makeDtoFromEntity(StockDataEntity e) {
        return new StockDataDto(e.getId(),
                                e.getStartDate(),
                                e.getTickerEntity(),
                                e.getTimeframeEntity(),
                                e.getOpenPrice(),
                                e.getHighPrice(),
                                e.getLowPrice(),
                                e.getClosePrice(),
                                e.getVolume());
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

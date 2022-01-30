package ru.stock.market.stockrest.converter;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import ru.stock.market.stockrest.dto.StockDto;
import ru.stock.market.stockrest.dto.TickerDto;
import ru.stock.market.stockrest.entity.StockEntity;
import ru.stock.market.stockrest.entity.TickerEntity;

@Component
@Log
public class TickerConverter extends StockConverter {

    @Override
    public void makeEntityFromDto(StockDto dto) {
        TickerDto ticker_dto = (TickerDto) dto;
        TickerEntity entity = new TickerEntity();
        entity.setId(ticker_dto.getId());
        entity.setName(ticker_dto.getName());
        entity.setDescription(ticker_dto.getDescription());
        setEntity(entity);
    }

    @Override
    public void makeDtoFromEntity(StockEntity se) {
        TickerEntity te = (TickerEntity) se;
        setDto(new TickerDto(te.getId(), te.getName(), te.getDescription()));
    }

    @Override
    public TickerDto makeDtoFromEntityStream(StockEntity e) {
        TickerEntity te = (TickerEntity) e;
        return new TickerDto(te.getId(), te.getName(), te.getDescription());
    }

}

package ru.stock.market.stockrest.converter;


import lombok.Getter;
import lombok.Setter;
import ru.stock.market.stockrest.dto.StockDto;
import ru.stock.market.stockrest.entity.StockEntity;

public class StockConverter implements ConverterInterface {
    @Setter
    @Getter
    StockEntity entity;

    @Setter
    @Getter
    StockDto dto;

    @Override
    public void makeEntityFromDto(StockDto d) {

    }

    @Override
    public void makeDtoFromEntity(StockEntity e) {

    }

    public StockDto makeDtoFromEntityStream(StockEntity stockEntity) {
        return null;
    }
}

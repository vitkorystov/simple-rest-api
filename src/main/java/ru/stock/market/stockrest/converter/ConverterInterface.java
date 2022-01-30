package ru.stock.market.stockrest.converter;


import ru.stock.market.stockrest.dto.StockDto;
import ru.stock.market.stockrest.entity.StockEntity;

public interface ConverterInterface {

    void makeEntityFromDto(StockDto d);

    void makeDtoFromEntity(StockEntity e);

    //StockDto makeDtoFromEntityStream(StockEntity e);


}

package ru.stock.market.stockrest.converter;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import ru.stock.market.stockrest.dto.StockDto;
import ru.stock.market.stockrest.dto.TimeframeDto;
import ru.stock.market.stockrest.entity.StockEntity;
import ru.stock.market.stockrest.entity.TimeframeEntity;


@Component
@Log
public class TimeframeConverter extends StockConverter {

    @Override
    public void makeEntityFromDto(StockDto dto) {
        TimeframeDto tf_dto = (TimeframeDto) dto;
        TimeframeEntity entity = new TimeframeEntity();
        entity.setId(tf_dto.getId());
        entity.setName(tf_dto.getName());
        entity.setDescription(tf_dto.getDescription());
        setEntity(entity);
    }

    @Override
    public void makeDtoFromEntity(StockEntity se) {
        TimeframeEntity te = (TimeframeEntity) se;
        setDto(new TimeframeDto(te.getId(), te.getName(), te.getDescription()));
    }

    @Override
    public TimeframeDto makeDtoFromEntityStream(StockEntity e) {
        TimeframeEntity te = (TimeframeEntity) e;
        return new TimeframeDto(te.getId(), te.getName(), te.getDescription());
    }

}

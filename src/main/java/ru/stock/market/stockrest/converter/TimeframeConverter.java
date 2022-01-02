package ru.stock.market.stockrest.converter;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import ru.stock.market.stockrest.dto.TimeframeDto;
import ru.stock.market.stockrest.entity.TimeframeEntity;


@Component
@Log
public class TimeframeConverter
        extends BaseConverter<TimeframeEntity, TimeframeDto> {

    @Override
    public TimeframeEntity makeEntityFromDto(TimeframeDto d) {
        TimeframeEntity entity = new TimeframeEntity();
        entity.setId(d.getId());
        entity.setName(d.getName());
        entity.setDescription(d.getDescription());
        return entity;
    }

    @Override
    public TimeframeDto makeDtoFromEntity(TimeframeEntity e) {
        return new TimeframeDto(e.getId(), e.getName(), e.getDescription());
    }

}

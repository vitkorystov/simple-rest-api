package ru.stock.market.stockrest.converter;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import ru.stock.market.stockrest.dto.TickerDto;
import ru.stock.market.stockrest.entity.TickerEntity;

@Component
@Log
public class TickerConverter extends BaseConverter<TickerEntity, TickerDto> {

    @Override
    public TickerEntity makeEntityFromDto(TickerDto d) {
        TickerEntity entity = new TickerEntity();
        entity.setId(d.getId());
        entity.setName(d.getName());
        entity.setDescription(d.getDescription());
        return entity;
    }

    @Override
    public TickerDto makeDtoFromEntity(TickerEntity e) {
        return new TickerDto(e.getId(), e.getName(), e.getDescription());
    }

}

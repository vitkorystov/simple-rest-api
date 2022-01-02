package ru.stock.market.stockrest.converter;


public interface ConverterInterface <Entity, Dto> {

    Entity makeEntityFromDto(Dto d);

    Dto makeDtoFromEntity(Entity e);
}

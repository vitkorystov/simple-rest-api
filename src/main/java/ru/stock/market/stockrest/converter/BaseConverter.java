package ru.stock.market.stockrest.converter;


public abstract class BaseConverter<Entity, Dto> implements ConverterInterface<Entity, Dto>{

    private Entity entity;

    private Dto dto;
}

package ru.stock.market.stockrest.service;


public abstract class AbstractService<Repository, Converter>{

    protected Repository repository;

    protected Converter converter;

}

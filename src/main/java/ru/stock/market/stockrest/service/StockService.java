package ru.stock.market.stockrest.service;


import lombok.extern.java.Log;
import ru.stock.market.stockrest.converter.StockConverter;
import ru.stock.market.stockrest.dto.StockDto;
import ru.stock.market.stockrest.entity.StockEntity;
import ru.stock.market.stockrest.repository.StockRepository;


@Log
public class StockService implements ServiceInterface {

    public StockConverter converter;
    public StockRepository repository;

    public StockDto save(StockDto dto) {
        converter.makeEntityFromDto(dto);
        StockEntity te = converter.getEntity();
        StockEntity savedEntity = repository.save(te);
        log.info("savedEntity: " + savedEntity);
        converter.makeDtoFromEntity(savedEntity);
        return converter.getDto();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
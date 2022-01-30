package ru.stock.market.stockrest.repository;

import ru.stock.market.stockrest.entity.StockEntity;

public interface StockRepository {

    StockEntity save(StockEntity e);

    void deleteById(Integer id);
}

package ru.stock.market.stockrest.repository;

import  ru.stock.market.stockrest.entity.TickerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TickersRepository extends JpaRepository<TickerEntity, Integer> {
    TickerEntity findTickerEntityByName(String name);
    TickerEntity findTickerEntityById(Integer id);
}

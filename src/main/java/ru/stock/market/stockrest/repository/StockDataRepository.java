package ru.stock.market.stockrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stock.market.stockrest.entity.StockDataEntity;


import java.math.BigInteger;

public interface StockDataRepository extends JpaRepository<StockDataEntity, BigInteger> {
}

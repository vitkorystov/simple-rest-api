package ru.stock.market.stockrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stock.market.stockrest.entity.TimeframeEntity;


public interface TimeframesRepository extends JpaRepository<TimeframeEntity, Integer>, StockRepository {

    TimeframeEntity findTimeframeEntityById(Integer id);

}

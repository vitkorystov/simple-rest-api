package ru.stock.market.stockrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.stock.market.stockrest.dto.StockDto;
import ru.stock.market.stockrest.dto.TickerDto;

import java.util.List;

public interface ControllerInterface<Dto> {
    List<Dto> getAll();
    ResponseEntity<Object> save(@RequestBody Dto dto);

    // ResponseEntity<Void> delete(@PathVariable Integer id);
    // ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody StockDto dto);
}

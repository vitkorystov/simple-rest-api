package ru.stock.market.stockrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControllerInterface <Dto> {
    List<Dto> getAll();
    ResponseEntity<Object> save(@RequestBody Dto dto);
    ResponseEntity<Void> delete(@PathVariable Integer id);
    ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Dto dto);
}

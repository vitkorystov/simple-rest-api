package ru.stock.market.stockrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.stock.market.stockrest.dto.StockDto;
import ru.stock.market.stockrest.response.ResponseHandler;
import ru.stock.market.stockrest.service.StockService;

public class StockController {

    protected StockService service;

    public ResponseEntity<Object> process_saving(StockDto dto,  String msg){
        try {
            service.save(dto);
            return ResponseHandler.generateResponse(msg, HttpStatus.CREATED, dto);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, dto);
        }
    }

    public ResponseEntity<Void> process_deleting(Integer id){
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}

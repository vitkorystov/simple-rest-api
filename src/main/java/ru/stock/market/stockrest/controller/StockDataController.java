package ru.stock.market.stockrest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import ru.stock.market.stockrest.dto.StockDataDtoSerialized;
//import ru.stock.market.stockrest.service.StockDataService;

import java.util.List;
/*
@AllArgsConstructor
@RestController
@RequestMapping("/stock-data")
@Log
@CrossOrigin
public class StockDataController extends AbstractController<StockDataService> {

    private StockDataService service;

    @GetMapping()
    public List<StockDataDtoSerialized> getAll() {
        log.info("Handling find all StockData request");
        return  service.findAll();

    }
}*/
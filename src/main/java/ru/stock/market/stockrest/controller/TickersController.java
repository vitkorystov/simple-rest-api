package ru.stock.market.stockrest.controller;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stock.market.stockrest.dto.TickerDto;
import ru.stock.market.stockrest.response.ResponseHandler;
import ru.stock.market.stockrest.service.TickerService;

import java.util.List;


@RestController
@RequestMapping("/ticker")
@Log
@CrossOrigin
public class TickersController extends StockController implements ControllerInterface<TickerDto> {

    protected TickerService service;

    TickersController(TickerService service) {
        this.service = service;
    }

    @GetMapping()
    public List<TickerDto> getAll() {
        log.info("Handling find all tickers");
        return service.findAll();
    }


    @PostMapping()
    public ResponseEntity<Object> save(@RequestBody TickerDto dto) {
        log.info("Handling saving ticker, tickerDto=" + dto);
        return process_saving(dto, "Ticker saved successfully!");
    }


    @GetMapping("/{id}/id")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        TickerDto dto = service.findById(id);
        if (dto != null) {
            log.info("Found ticker with id" + id + ": " + dto);
            return ResponseHandler.generateResponse("Ticker with id '" + id + "' exists!", HttpStatus.OK, dto);
        } else {
            return ResponseHandler.generateResponse("Ticker with name '" + id + "' NOT found!", HttpStatus.OK, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        log.info("Handling delete ticker: " + id);
        return process_deleting(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody TickerDto dto) {
        log.info("PUT: id=" + id + " | tickerDto" + dto);
        try {
            service.update(id, dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

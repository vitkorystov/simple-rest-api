package ru.stock.market.stockrest.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.stock.market.stockrest.dto.TickerDto;
import ru.stock.market.stockrest.response.ResponseHandler;
import ru.stock.market.stockrest.service.TickerService;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;


@AllArgsConstructor
@RestController
@RequestMapping("/ticker")
@Log
@CrossOrigin
public class TickersController
        extends AbstractController<TickerService>
        implements ControllerInterface<TickerDto>{

    private final TickerService service;

    @GetMapping()
    public List<TickerDto> getAll() {
        log.info("Handling find all tickers");
        return service.findAll();
    }

    @PostMapping ()
    public ResponseEntity<Object> save(@RequestBody TickerDto tickerDto) {
        log.info("Handling saving ticker, tickerDto=" + tickerDto);
        TickerDto dto = null;
        try {
            dto = service.save(tickerDto);
            return ResponseHandler.generateResponse("Ticker saved successfully!", HttpStatus.CREATED, dto);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, dto);
        }
    }

    @GetMapping("/{name}/name")
    public ResponseEntity<Object> getByName(@PathVariable String name) {
        TickerDto dto = service.findByName(name);
        if (dto != null) {
            log.info("Found ticker with name" + name + ": " + dto);
            return ResponseHandler.generateResponse("Ticker with name '" + name + "' exists!", HttpStatus.OK, dto);
        } else {
            return ResponseHandler.generateResponse("Ticker with name '" + name + "' NOT found!", HttpStatus.OK, null);
        }
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
        log.info("Handling delete user request: " + id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody TickerDto dto) {
        log.info("PUT: id=" + id + " | tickerDto" + dto);
        service.update(id, dto);
        return ResponseEntity.ok().build();
    }
}

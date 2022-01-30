package ru.stock.market.stockrest.controller;

import java.util.List;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stock.market.stockrest.dto.TimeframeDto;
import ru.stock.market.stockrest.response.ResponseHandler;
import ru.stock.market.stockrest.service.TimeframeService;


@RestController
@RequestMapping("/timeframe")
@Log
@CrossOrigin
public class TimeframesController extends StockController implements ControllerInterface<TimeframeDto>{

    protected TimeframeService service;

    TimeframesController(TimeframeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<TimeframeDto> getAll() {
        log.info("Handling find all timeframes");
        return service.findAll();
    }

    @PostMapping()
    public ResponseEntity<Object> save(@RequestBody TimeframeDto dto) {
        log.info("Handling saving timeframe, TimeframeDto=" + dto);
        return process_saving(dto, "Timeframe saved successfully!");
    }

    @GetMapping("/{id}/id")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        TimeframeDto dto = service.findById(id);
        if (dto != null) {
            log.info("Found Timeframe with id" + id + ": " + dto);
            return ResponseHandler.generateResponse("Timeframe with id '" + id + "' exists!", HttpStatus.OK, dto);
        } else {
            return ResponseHandler.generateResponse("Timeframe with name '" + id + "' NOT found!", HttpStatus.OK, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        log.info("Handling delete timeframe: " + id);
        return process_deleting(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody TimeframeDto dto) {
        log.info("PUT: -->    id=" + id + " | timeframeDto" + dto);
        try {
            service.update(id, dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}

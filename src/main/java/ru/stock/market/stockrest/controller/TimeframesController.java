package ru.stock.market.stockrest.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.stock.market.stockrest.dto.TimeframeDto;
import ru.stock.market.stockrest.response.ResponseHandler;
import ru.stock.market.stockrest.service.TimeframeService;


@RestController
@RequestMapping("/timeframe")
@AllArgsConstructor
@Log
@CrossOrigin
public class TimeframesController extends AbstractController <TimeframeService> {

    private final TimeframeService service;

    @GetMapping("/")
    public List<TimeframeDto> getAll() {
        log.info("Handling find all timeframes");
        return service.findAll();
    }

    @PostMapping ()
    public ResponseEntity<Object> save(@RequestBody TimeframeDto dto) {
        log.info("Handling saving ticker, tickerDto=" + dto);
        TimeframeDto dto_response = null;
        try {
            dto_response = service.save(dto);
            return ResponseHandler.generateResponse("Timeframe saved successfully!", HttpStatus.CREATED, dto_response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, dto_response);
        }
    }


    @GetMapping("/{name}/name")
    public ResponseEntity<Object> getByName(@PathVariable String name) {
        TimeframeDto dto = service.findByName(name);
        if (dto != null) {
            log.info("Found ticker with name" + name + ": " + dto);
            return ResponseHandler.generateResponse("Timeframe with name '" + name + "' exists!", HttpStatus.OK, dto);
        } else {
            return ResponseHandler.generateResponse("Timeframe with name '" + name + "' NOT found!", HttpStatus.OK, null);
        }
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
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@PathVariable Integer id,
                                        @RequestBody TimeframeDto dto
    ) {
        log.info("PUT: -->    id=" + id + " | tickerDto" + dto);
        service.update(id, dto);
        return ResponseEntity.ok().build();
    }


}

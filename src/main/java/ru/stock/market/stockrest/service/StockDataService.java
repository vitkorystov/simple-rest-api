package ru.stock.market.stockrest.service;

import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.stock.market.stockrest.converter.StockDataConverter;
import ru.stock.market.stockrest.dto.StockDataDtoSerialized;
import ru.stock.market.stockrest.repository.StockDataRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Log
public class StockDataService extends AbstractService<StockDataRepository, StockDataConverter> {

    StockDataService(StockDataRepository r, StockDataConverter c){
        this.repository = r;
        this.converter = c;
    }

    public List<StockDataDtoSerialized> findAll() {

        return repository.findAll(PageRequest.of(0, Integer.parseInt(System.getenv("MAX_ROW")),
                        Sort.by(Sort.Direction.DESC, "id")))
                        .stream()
                        .map(converter::makeDtoResponseFromEntity)
                        .collect(Collectors.toList());
    }
}

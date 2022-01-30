package ru.stock.market.stockrest.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.stock.market.stockrest.converter.TimeframeConverter;
import ru.stock.market.stockrest.dto.TimeframeDto;
import ru.stock.market.stockrest.entity.StockEntity;
import ru.stock.market.stockrest.entity.TimeframeEntity;
import ru.stock.market.stockrest.repository.TimeframesRepository;


@Service
@Log
public class TimeframeService extends StockService {

    private final TimeframesRepository repository;
    private final TimeframeConverter converter;

    TimeframeService(TimeframesRepository r, TimeframeConverter c){
        this.repository = r;
        this.converter = c;
    }

    public List<TimeframeDto> findAll(){
        PageRequest of = PageRequest.of(0, Integer.parseInt(System.getenv("MAX_ROW")), Sort.by(Sort.Direction.DESC, "id"));
        return repository.findAll(of)
                .stream().map(converter::makeDtoFromEntityStream)
                .collect(Collectors.toList());
    }

    public TimeframeDto findById(Integer id) {
        TimeframeEntity te = repository.findTimeframeEntityById(id);
        if (te == null) {
            return null;
        }
        converter.makeDtoFromEntity(te);
        return (TimeframeDto) converter.getDto();
    }

    public void update(Integer id, TimeframeDto dto) {
        TimeframeEntity entity = repository.findTimeframeEntityById(id);
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        repository.save((StockEntity) entity);
    }

}

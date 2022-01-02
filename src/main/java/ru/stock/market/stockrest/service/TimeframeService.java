package ru.stock.market.stockrest.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.stock.market.stockrest.converter.TimeframeConverter;
import ru.stock.market.stockrest.dto.TimeframeDto;
import ru.stock.market.stockrest.entity.TimeframeEntity;
import ru.stock.market.stockrest.repository.TimeframesRepository;


@Service
@Log
public class TimeframeService
        extends AbstractService <TimeframesRepository, TimeframeConverter>
        implements ServiceInterface<TimeframeEntity, TimeframeDto> {


    TimeframeService(TimeframesRepository r, TimeframeConverter c){
        this.repository = r;
        this.converter = c;
    }

    public TimeframeDto save(TimeframeDto dto){
        TimeframeEntity te = converter.makeEntityFromDto(dto);
        TimeframeEntity savedEntity = repository.save(te);
        log.info("saved TimeframeEntity: " + savedEntity);
        return converter.makeDtoFromEntity(savedEntity);
    }

    public List<TimeframeDto> findAll(){
        return repository.findAll(PageRequest.of(0, Integer.parseInt(System.getenv("MAX_ROW")),
                        Sort.by(Sort.Direction.DESC, "id")))
                .stream()
                .map(converter::makeDtoFromEntity)
                .collect(Collectors.toList());
    }

    public TimeframeDto findByName(String name) {
        TimeframeEntity te = repository.findTimeframeEntityByName(name);
        if (te == null) {
            return null;
        }
        return converter.makeDtoFromEntity(te);
    }

    public TimeframeDto findById(Integer id) {
        TimeframeEntity te = repository.findTimeframeEntityById(id);
        if (te == null) {
            return null;
        }
        return converter.makeDtoFromEntity(te);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void update(Integer id, TimeframeDto dto) {
        TimeframeEntity ticker = repository.findTimeframeEntityById(id);
        if (ticker != null) {
            ticker.setName(dto.getName());
            ticker.setDescription(dto.getDescription());
            repository.save(ticker);
        }
    }
}

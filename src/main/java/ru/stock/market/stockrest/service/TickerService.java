package ru.stock.market.stockrest.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.stock.market.stockrest.converter.TickerConverter;
import ru.stock.market.stockrest.dto.TickerDto;
import ru.stock.market.stockrest.entity.TickerEntity;
import ru.stock.market.stockrest.repository.TickersRepository;


@Service
@Log
public class TickerService
        extends AbstractService<TickersRepository, TickerConverter>
        implements ServiceInterface<TickerEntity, TickerDto>{

    TickerService(TickersRepository r, TickerConverter c){
        this.repository = r;
        this.converter = c;
    }

    public TickerDto save(TickerDto tickerDto){
        TickerEntity te = converter.makeEntityFromDto(tickerDto);
        TickerEntity savedTickerEntity = repository.save(te);
        log.info("savedTickerEntity: " + savedTickerEntity);
        return converter.makeDtoFromEntity(savedTickerEntity);
    }

    public List<TickerDto> findAll(){
        return repository.findAll(PageRequest.of(0, Integer.parseInt(System.getenv("MAX_ROW")),
                        Sort.by(Sort.Direction.DESC, "id")))
                .stream()
                .map(converter::makeDtoFromEntity)
                .collect(Collectors.toList());
    }

    public TickerDto findByName(String name) {
        TickerEntity te = repository.findTickerEntityByName(name);
        if (te == null) {
            return null;
        }
        return converter.makeDtoFromEntity(te);
    }

    public TickerDto findById(Integer id) {
        TickerEntity te = repository.findTickerEntityById(id);
        if (te == null) {
            return null;
        }
        return converter.makeDtoFromEntity(te);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void update(Integer id, TickerDto dto) {
        TickerEntity ticker = repository.findTickerEntityById(id);
        ticker.setName(dto.getName());
        ticker.setDescription(dto.getDescription());
        repository.save(ticker);
    }

}

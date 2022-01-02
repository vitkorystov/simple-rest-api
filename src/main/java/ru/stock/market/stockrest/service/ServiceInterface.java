package ru.stock.market.stockrest.service;

import java.util.List;

public interface ServiceInterface <Entity, Dto> {

    void delete(Integer id);

    Dto save(Dto d);

    void update(Integer id, Dto d);

    List<Dto> findAll();
}

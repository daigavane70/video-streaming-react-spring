package com.sprint.server.controller;

import com.sprint.common.response.HttpApiResponse;
import com.sprint.common.response.HttpErrorResponse;
import com.sprint.repository.entity.Stocks;
import com.sprint.repository.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/stocks")
public class StockController {
    @Autowired
    StockRepository stockRepository;

    @GetMapping
    HttpApiResponse getAll(){
        List<Stocks> stocks = stockRepository.findAll();
        return new HttpApiResponse(stocks);
    }

    @GetMapping("/{id}")
    HttpApiResponse getStockById(@PathVariable int id) {
        Optional<Stocks> stocks = stockRepository.findById(Long.valueOf(id));
        if (stocks.isPresent())
            return new HttpApiResponse(stocks);
        return new HttpApiResponse(false, null, new HttpErrorResponse(404, "No Stocks Found"));
    }
}

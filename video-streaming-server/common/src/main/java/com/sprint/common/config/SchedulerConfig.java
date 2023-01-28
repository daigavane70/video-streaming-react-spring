package com.sprint.common.config;

import com.sprint.repository.entity.Stocks;
import com.sprint.repository.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Configuration
@EnableScheduling
@Slf4j
public class SchedulerConfig {

    public static double count = 1;
    private static List<Stocks> stocks;

    Random random = new Random();

    @Autowired
    StockRepository stockRepository;

    @PostConstruct
    void updateStocks() {
        this.stocks = stockRepository.findAll();
    }

    @Scheduled(fixedDelay = 2000)
    public void scheduleFixedDelayTask() {
        log.info("[schedularCount] current count: {}", count);
        count = count + Math.random() * 10;
    }

    @Scheduled(fixedDelay = 1000)
    private void alterStockPrice() {
        for (Stocks stock : stocks) {
            double initialValue = stock.getPrice();
            double temp = Math.random() * 10;
            boolean add = random.nextBoolean();
            double newValue = Math.max(Math.min(add ? initialValue + temp : initialValue - temp, 1000), 100);
            stock.setPrice(newValue);
            stockRepository.save(stock);
            log.info("[stockValueUpdate] stock: {}, from {} to {}", stock.getName(), initialValue, newValue);
        }
    }
}

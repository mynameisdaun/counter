package com.count.demo.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CounterService {

    private final CounterRepository counterRepository;

    public Counter count(String host) {
        System.out.println("host: "+host);
        if(!host.equals("ykim22") && !host.equals("scchae")) {
            throw new IllegalStateException("");
        }
        Counter counter = new Counter(host, LocalDateTime.now());
        return counterRepository.save(counter);
    }

    public List<Counter> check(String host, LocalDateTime created) {
        System.out.println("host: "+host);
        if(!host.equals("ykim22") && !host.equals("scchae")) {
            throw new IllegalStateException("");
        }
        return counterRepository.findAllByHostAndCreatedAfter(host, created);
    }
}

package com.count.demo.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class CounterService {

    private final CounterRepository counterRepository;

    public Counter count() {
        Counter counter = new Counter();
        counter.setCreated(LocalDateTime.now());
        return counterRepository.save(counter);
    }
}

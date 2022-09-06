package com.count.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Getter
public class ModelCounter {

    private Long id;

    private String host;

    private String created;

    public ModelCounter(Long id, String host, LocalDateTime created) {
        this.id = id;
        this.host = host;
        this.created = created.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public ModelCounter(Counter counter) {
        this.id = counter.getId();
        this.host = counter.getHost();
        this.created = counter.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}

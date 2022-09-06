package com.count.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String host;

    @Column
    private LocalDateTime created;

    public Counter(String host, LocalDateTime created) {
        this.host = host;
        this.created = created;
    }
}

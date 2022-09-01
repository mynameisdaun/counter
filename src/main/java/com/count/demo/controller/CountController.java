package com.count.demo.controller;

import com.count.demo.model.CounterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Enumeration;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CountController {

    private final CounterService counterService;

    @GetMapping("/counter")
    public String counter(HttpServletRequest req) {
        try {
            counterService.count();
        } catch (Exception e) {
            log.error("{}", LocalDateTime.now());
        }
        return "counter";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest req) {
        try {
            counterService.count();
        } catch (Exception e) {
            log.error("{}", LocalDateTime.now());
        }
        return "counter";
    }
}

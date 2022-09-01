package com.count.demo.controller;

import com.count.demo.model.CounterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CountController {

    private final CounterService counterService;

    @GetMapping("/counter")
    public String counter(HttpServletRequest req) {
        try {
            log.info("{}", "새로운 회원이 요청하셨습니다");
            counterService.count();
        } catch (Exception e) {
            log.error("{}", LocalDateTime.now());
        }
        return "counter";
    }
}

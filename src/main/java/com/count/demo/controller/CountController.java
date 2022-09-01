package com.count.demo.controller;

import com.count.demo.model.Counter;
import com.count.demo.model.CounterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/check")
    public String check(Model model) {
        List<Counter> counters = counterService.check();
        model.addAttribute("total",counters.size());
        model.addAttribute("counters",counters);
        return "check";
    }
}

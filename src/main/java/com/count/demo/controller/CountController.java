package com.count.demo.controller;

import com.count.demo.model.Counter;
import com.count.demo.model.CounterService;
import com.count.demo.model.ModelCounter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CountController {

    private final CounterService counterService;

    @GetMapping("/counter")
    public String counter(@RequestParam("host") String host) {
        try {
            counterService.count(host);
        } catch (Exception e) {
            log.error("{}", LocalDateTime.now());
        }
        return "counter";
    }

    @GetMapping("/check")
    public String check(@RequestParam("host") String host,
                        @RequestParam("date") @Nullable String date,
                        Model model) {
        LocalDateTime created = LocalDateTime.now().minusDays(5);
        try {
            if(date != null) {
                LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                created = LocalDateTime.of(ld, LocalTime.MIDNIGHT);
                System.out.println(created);
            }
        } catch(Exception e) {
                e.printStackTrace();
        }
        List<Counter> counters = counterService.check(host, created);
        List<ModelCounter> modelCounters = new ArrayList<>();
        for(int i = 0 ; i < counters.size() ; i++) {
            modelCounters.add(
                    new ModelCounter(Long.valueOf(i+1), counters.get(i).getHost(), counters.get(i).getCreated())
            );
        }
        model.addAttribute("date", created.toLocalDate().toString());
        model.addAttribute("host", host);
        model.addAttribute("total", modelCounters.size());
        model.addAttribute("counters", modelCounters);
        return "check";
    }
}

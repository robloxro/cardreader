package com.roblox.cardreader;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController

public class CheckinController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/cardCheck")
    //long id, Date data, long cardId, String username, String action
    public CardCheck greeting(@RequestParam(value = "cardId", defaultValue = "0") long cardId) {
        return new CardCheck(counter.incrementAndGet(), cardId, new Date().getTime(), "User", "IN");
    }
}
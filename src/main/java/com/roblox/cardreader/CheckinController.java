package com.roblox.cardreader;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "/cardCheck")
public class CheckinController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path={"/v1.0","/"})
    //long id, Date data, long cardId, String username, String action
    public CardCheck cardCheck(@RequestParam(value = "cardId", defaultValue = "0") long cardId) {
        return new CardCheck(counter.incrementAndGet(), cardId, new Date().getTime(), "User", "IN");
    }
    @PostMapping(path={"/v1.0","/"}, consumes = "application/xml;charset=UTF-8")
    public String create(@RequestBody CardCheck cardCheck) {

       return "Posted card action is "+cardCheck.getUsername() +" checked card "+cardCheck.getId() +
                " at "+cardCheck.getData()+" as " + cardCheck.getAction() + " action";
       // should put an event on a topic to be consumed by the emailReader to send greetings for first day and by the dataCollector to store in the db

    }
}
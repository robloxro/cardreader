package com.roblox.cardreader;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "/cardCheck")
public class CheckinController {


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(path="/")
    //long id, Date data, long cardId, String username, String action
    public CardCheck greeting(@RequestParam(value = "cardId", defaultValue = "0") long cardId) {
        return new CardCheck(counter.incrementAndGet(), cardId, new Date().getTime(), "User", "IN");
    }
    @PostMapping(path="/", consumes = "application/xml;charset=UTF-8")
    public String customerInformation(@RequestBody CardCheck cardCheck) {

       return "Posted card action is "+cardCheck.getUsername() +" checked card "+cardCheck.getId() +
                " at "+cardCheck.getData()+" as " + cardCheck.getAction() + " action";
    }
}
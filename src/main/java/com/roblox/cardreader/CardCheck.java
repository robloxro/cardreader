package com.roblox.cardreader;

import java.util.Date;

public class CardCheck {
    private final long id;

    public long getData() {
        return data;
    }

    private final long data;
    private final long cardId;
    private final String username;
    private final String action;


    public long getId() {
        return id;
    }



    public long getCardId() {
        return cardId;
    }

    public String getUsername() {
        return username;
    }

    public String getAction() {
        return action;
    }

    public CardCheck(long id, long data, long cardId, String username, String action) {
        this.id = id;
        this.data = data;
        this.cardId = cardId;
        this.username = username;
        this.action = action;
    }
}

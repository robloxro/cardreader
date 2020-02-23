package com.roblox.cardreader;



public class CardCheck {

    private  long id;
    private  long data;
    private  long cardId;
    private  String username;
    private  String action;

    public CardCheck() {
    }

    public CardCheck(long id, long data, long cardId, String username, String action) {
        this.id = id;
        this.data = data;
        this.cardId = cardId;
        this.username = username;
        this.action = action;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setData(long data) {
        this.data = data;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public long getData() {
        return data;
    }

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


}

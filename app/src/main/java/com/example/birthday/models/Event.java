package com.example.birthday.models;

public class Event {
    private String data;
    private String event;
    private int id;
    private int idPerson;

    public Event(String data, String event, int id, int idPerson) {
        this.data = data;
        this.event = event;
        this.id = id;
        this.idPerson = idPerson;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
}

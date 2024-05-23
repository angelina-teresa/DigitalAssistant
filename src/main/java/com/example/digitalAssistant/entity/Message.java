package com.example.digitalAssistant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Message {
    @Id
    private String name;
    private String response;

    public Message() {
    }
    public Message(String name, String response) {
        this.name = name;
        this.response = response;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }

}

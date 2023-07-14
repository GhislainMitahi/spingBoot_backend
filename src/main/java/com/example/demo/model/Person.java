package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person{
    private final UUID id;
    private String name;

    public Person(@JsonProperty("id") UUID id,
                 @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}

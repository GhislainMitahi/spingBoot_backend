package com.example.demo.model;

import java.util.UUID;

public class Person {
    private final UUID id;
    private String name;

    public Person(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId(){
        return this.id;
    }

    public String getNam(){
        return this.name;
    }

}

package ru.gb.example_homework4.domain;

import lombok.Data;

@Data // автоматическое добавление конструктора, геттеров и сеттеров, переопределяет toString
public class Person {

    private int id;
    private String name;
    private String pass;

}

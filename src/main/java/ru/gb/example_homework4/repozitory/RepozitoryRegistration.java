package ru.gb.example_homework4.repozitory;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.gb.example_homework4.domain.Person;

import java.util.ArrayList;
import java.util.List;
@Data
@Repository
public class RepozitoryRegistration {
    private static int ID;

   private List<Person> list = new ArrayList<>();
//    {
//        Person person = new Person();
//        person.setName("Mike");
//        person.setPass("pass");
//        list.add(person);
//    }

    // метод показывает зарегистрированных Юзеров
    public List<Person> allPersons(){
        return list;
    }

    // метод добовляет Юзера в БД
    public void addPerson(Person person){
        person.setId(++ID); // автоматически присваивается id
        list.add(person);
    }
}

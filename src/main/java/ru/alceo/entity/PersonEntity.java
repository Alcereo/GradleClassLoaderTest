package ru.alceo.entity;

import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

/**
 * Created by alcereo on 30.05.17.
 */
@EntityScan
public class PersonEntity {

    private String name;
    private Integer age;

    public PersonEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

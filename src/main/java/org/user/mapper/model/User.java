package org.user.mapper.model;

import org.user.mapper.service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phoneNumber;
    private int age;

    public User() {
    }

    public User(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        setBirthDate(birthDate);
    }

    public User(String name, String surname, LocalDate birthDate, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        setBirthDate(birthDate);
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        setAge(UserService.calculateUserAge(this));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}

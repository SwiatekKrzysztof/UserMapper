package org.user.mapper.model;

import sun.util.calendar.LocalGregorianCalendar;

public class User {
    private String name;
    private String surname;
    private LocalGregorianCalendar.Date birthDate;
    private String phoneNumber;

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

    public LocalGregorianCalendar.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalGregorianCalendar.Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

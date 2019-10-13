package org.user.mapper.service;

import org.user.mapper.model.User;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserService {
    public List<User> createUsers(List<String> linesList){
        List<User> users = new ArrayList<>();
        String[] line;
        String[] dateLine;
        for (int i = 0; i < linesList.size(); i++) {
            line = linesList.get(i).split(",");
            User newUser = new User();
            newUser.setName(line[0]);
            newUser.setSurname(line[1]);
            dateLine = line[2].split("-");
            newUser.setBirthDate(LocalDate.of(
                    Integer.parseInt(dateLine[0]),
                    Integer.parseInt(dateLine[1]),
                    Integer.parseInt(dateLine[2])));
            if(line.length<4){
                newUser.setPhoneNumber("UNKNOWN");
            } else {
                newUser.setPhoneNumber(line[3]);
            }
            users.add(newUser);
        }
        return users;
    }

}

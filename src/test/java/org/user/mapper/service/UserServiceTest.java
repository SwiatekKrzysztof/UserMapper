package org.user.mapper.service;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.user.mapper.model.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(JUnitParamsRunner.class)
public class UserServiceTest {
    UserService userService;
    User user;
    List<String> linesList;
    List<User> users;
    @Before
    public void init() {
        userService = new UserService();
        user = new User();

        linesList = Arrays.asList(
                "John,Smith,1995-11-02,502222222",
                "Jan,Kowalski,1990-02-02,123123123",
                "Bartłomiej,Nowak,1800-03-01");
        users = Arrays.asList(
                new User("John","Smith",LocalDate.parse("1995-11-02"),"502222222"),
                new User("Jan","Kowalski",LocalDate.parse("1990-02-02"),"123123123"),
                new User("Bartłomiej","Nowak",LocalDate.parse("1800-03-01"),"UNKNOWN")
        );
    }
    @Test
    public void createUsers() {
        // when
        List<User> resultList = userService.createUsers(linesList);

        // then
        for (int i = 0; i < resultList.size(); i++) {
            assertThat(resultList.get(i)).isEqualToComparingFieldByField(users.get(i));
        }
    }
    @Test
    @Parameters({
            "1995-11-02,23",
            "1920-01-01,99",
            "1800-01-31,219",
    })
    public void calculateUserAgeTest(String dateString, int expected) {
        // when
        user.setBirthDate(LocalDate.parse(dateString));
        int result = user.getAge();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
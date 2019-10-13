package org.user.mapper;

import org.user.mapper.model.User;
import org.user.mapper.service.FileService;
import org.user.mapper.service.UserService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        FileService fileService = new FileService();
        List<String> linesList = fileService.parseTextFile("C:\\Users\\48501\\TestFolder\\test.txt");
        //linesList.forEach(System.out::println);
        UserService userService = new UserService();
        List<User> users = userService.createUsers(linesList);
        users.forEach(System.out::println);
        userService.printUsers(users);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert file path (Windows )");
        String path = scanner.nextLine();
    }
}

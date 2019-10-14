package org.user.mapper;

import org.user.mapper.model.User;
import org.user.mapper.service.FileService;
import org.user.mapper.service.UserService;

import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to User Mapper program");
        String path = "";
        FileService fileService = new FileService();
        UserService userService = new UserService();

        boolean pathValid = false;
        while(!pathValid) {
            System.out.println("Please insert your .txt file path (Windows style)");
            path = scanner.nextLine();
            pathValid = fileService.isPathValid(path);
            if(!pathValid)
                System.out.println("Path incorrect");
        }

        List<String> linesList = fileService.parseTextFile(path);
        List<User> users = userService.createUsers(linesList);
        System.out.println();
        userService.printUsers(users);

        System.out.println("Users present: " + users.size());
    }
}

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
        //C:\\Users\\48501\\TestFolder\\test.txt
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to User Mapper program");
        boolean pathValid = false;
        String path = "";
        FileService fileService = new FileService();
        UserService userService = new UserService();

        while(!pathValid) {
            System.out.println("Please insert your .txt file path (Windows style)");
            path = scanner.nextLine();
            pathValid = fileService.isPathValid(path);
            if(!pathValid)
                System.out.println("Path incorrect");
        }

        List<String> linesList = fileService.parseTextFile(path);

        List<User> users = userService.createUsers(linesList);
        userService.printUsers(users);

    }
}

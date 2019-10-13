package org.user.mapper;

import org.user.mapper.service.FileService;

import java.io.File;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        FileService fileService = new FileService();
        List<String> linesList = fileService.parseTextFile("C:\\Users\\48501\\TestFolder\\test.txt");
        linesList.forEach(System.out::println);

    }
}

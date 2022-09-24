package com.students;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class main {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Student std = new Student("Danushka", 28);
            Student std1 = new Student("Vimukthi", 30);
            Path filePath = Paths.get("E:\\ProgramInterlij\\com.maven\\src\\main\\resources\\student.txt");
            mapper.writeValue(filePath.toFile(), std);
            mapper.writeValue(filePath.toFile(), std1);
            System.out.println();
            Student S=mapper.readValue(filePath.toFile(),Student.class);
            System.out.println(std.getName());
        }catch(Exception e){
            e.fillInStackTrace();
        }


    }
}

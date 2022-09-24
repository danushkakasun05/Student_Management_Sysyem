package Assignment_02;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Subjects{
    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    private String sub;
    private int marks;
    public Subjects(String sub) {
        this.sub =sub;

    }




}

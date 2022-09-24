package Assignment_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Student {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    private int marks;

    public Student(){}

    public Student(String name){
        this.name =name;
    }
    public Student(String name,int marks){
        this.name =name;
        this.marks =marks;}


}

package Assignment_02;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class main {
    public static void main(String[] args) {
        while(true) {
            try {


                // Map<String, Integer> maps = new HashMap<>();
                System.out.println("A. Student management: ");
                System.out.println("B. Subject management: ");
                System.out.println("C. find the grades: ");
                System.out.println("D. Exist from Management System: ");

                Scanner input = new Scanner(System.in);
                System.out.println("Enter your options Here: ");
                String option = input.next();
                Student_main student = new Student_main();
                Subjects_main subject = new Subjects_main();
                findClass grade = new findClass();
                switch (option) {

                    //ObjectMapper mapper = new ObjectMapper();
                    case "A":
                        student.StudentMain();
                        break;
                    case "B":
                        subject.subjectMain();
                        break;
                    case "C":
                        grade.findClass();
                        break;
                    case "D":
                        return;
                    default:
                        System.out.println("enter valid input");
                }


            } catch (InputMismatchException e) {
                System.out.println("Enter valid number" + e);
            } catch (Exception e) {
                System.out.println("error" + e);
            }
        }

    }
}

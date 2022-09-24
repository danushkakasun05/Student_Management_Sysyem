package Assignment_02;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.stream.Stream;

import static java.nio.file.Files.createFile;
import static java.nio.file.Files.list;

public class Student_main{
    public List<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(List<Student> studentList) {
        StudentList = studentList;
    }

    private List<Student>StudentList;
    public  void StudentMain() throws Exception {
            while (true) {
                try{

                    Scanner input = new Scanner(System.in);
                    System.out.println("Students detais");
                    System.out.println(1 + " Add Student:");
                    System.out.println(2 + " view Students:");
                    System.out.println(3 + " search Student:");
                    System.out.println(4 + " Remove Student:");
                    System.out.println(5 + " add Subject marks:");
                    System.out.println(6 + " access to Main page");
                    System.out.println("Enter your option:");
                    int option = input.nextInt();
                    switch (option) {
                        case 1:
                            System.out.print("Enter student name: ");
                            String stname = input.next();
                            Path filePath = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\"+stname+".txt");
                            if (Files.exists(filePath)){
                                System.out.print("Same name student already registered");
                            }else {
                                Files.createFile(filePath);
                                boolean x=true;
                                while (x) {
                                    System.out.println("do you want to separate mark input or are you going to input marks for all students using option 5");
                                    System.out.println("if you want to enter mark separately give a option as Y other wise Enter N: ");
                                    String opt = input.next();


                                    switch (opt) {
                                        case "Y":
                                            seperateInput sptI = new seperateInput();
                                            sptI.seperateMarksInput(stname);
                                            x=false;
                                            break;
                                        case "N":
                                            x=false;
                                        default:
                                            System.out.println("Enter valid input");
                                            break;

                                    }
                                }
                            }

                            System.out.println();
                            break;
                        case 2:
                            System.out.println("Student name list: ");
                            Path directPath = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\");
                            String[] namelist = directPath.toFile().list();
                            if(namelist.length==0){
                                throw new customException("Enter at least one students before process this option");
                            }
                            for (int k = 0; k < namelist.length; k++) {
                                String s = namelist[k].toString();
                                System.out.println(s.substring(0, s.length() - 4));
                            }

                            break;
                        case 3:
                            System.out.println("Enter name: ");
                            String name = input.next();
                            Path stdpath = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\" + name + ".txt");
                            if (Files.exists(stdpath)) {
                                System.out.println("Available");
                            } else {
                                System.out.println("No such student");
                            }
                            break;
                        case 4:
                            System.out.println("Enter delete name: ");
                            String name2 = input.next();
                            Path stdpath2 = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\" + name2 + ".txt");
                            if (Files.exists(stdpath2)) {
                                Files.delete(stdpath2);
                            } else {
                                System.out.println("there is no such name");
                            }
                            break;
                        case 5:
                            Map<String, Integer> maps = new HashMap<>();
                            ObjectMapper mapper = new ObjectMapper();
                            System.out.println("Add marks to students");
                            Path directPathStd = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\");
                            String[] namelistStd = directPathStd.toFile().list();
                            if (namelistStd.length ==0){
                                throw new customException("Please enter atl east one student to proceed");
                            }
                            Path directPathSub = Paths.get("E:\\ProgramInterlij\\com.maven\\Subjects\\");
                            String[] namelistSub = directPathSub.toFile().list();
                            if (namelistSub.length ==0){
                                throw new customException("Please enter at least one subject to proceed");
                            }
                            int mark = 0;
                            for (int i = 0; i < namelistStd.length; i++) {
                                String std = namelistStd[i].toString().substring(0, namelistStd[i].length() - 4);
                                System.out.println("Enter " + std + " marks of following subjects");
                                for (int j = 0; j < namelistSub.length; j++) {
                                    String subs = namelistSub[j].toString().substring(0, namelistSub[j].length() - 4);
                                    System.out.println("Enter " + subs + " marks");
                                    mark = input.nextInt();
                                    System.out.println(subs);
                                    maps.put(subs, mark);
                                }
                                System.out.println(maps);
                                Path filePath2 = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\" + namelistStd[i].toString().substring(0, namelistStd[i].length() - 4) + ".txt");
                                mapper.writeValue(filePath2.toFile(), maps);
                            }
                            break;
                        case 6:
                            return;
                        default:
                            System.out.println("Enter valid input");
                            break;
                }
                }catch(InputMismatchException e){
                    System.out.println("enter valid integer input "+e);
                }catch(Exception e){
                    System.out.println("Error: "+e);

                }
        }

    }

}


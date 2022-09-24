package Assignment_02;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.source.tree.CatchTree;

import java.util.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Subjects_main {
    public List<Subjects> getSubjectslist() {
        return subjectslist;
    }

    public void setSubjectslist(List<Subjects> subjectslist) {
        this.subjectslist = subjectslist;
    }

    private List<Subjects> subjectslist;
    public void subjectMain()throws Exception{
        Scanner input = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        List<Subjects> subs = new ArrayList<>();
        while (true) {
            try {
            System.out.println("subject details");
            System.out.println(1 + " add subjects: ");
            System.out.println(2 + " subject details: ");
            System.out.println(3 + " delete subject: ");
            System.out.println(4 + " access to Main page");
            System.out.print("Enter your option:");
            int option = input.nextInt();
            switch (option) {

                    case 1:
                        System.out.println("enter your Subject name: ");
                        String subject = input.next();
                        Subjects sbjt = new Subjects(subject);
                        subs.add(sbjt);
                        Path paths = Paths.get("E:\\ProgramInterlij\\com.maven\\Subjects\\" + subject + ".txt");
                        if(Files.exists(paths)){
                            System.out.println("already add this subject");
                        }else {
                            Files.createFile(paths);
                            mapper.writeValue(paths.toFile(), sbjt);
                            boolean x=true;
                            while (x) {
                                System.out.println("are you going to add this subject marks to each and every student seperately or all subjects marks add again to each students");
                                System.out.println("if you want to enter this sub mark separately to each and every student give a option as Y other wise Enter N: ");
                                String opt = input.next();
                                switch (opt) {
                                    case "Y":
                                        seperateInput sptI = new seperateInput();
                                        sptI.seperateSubjectmarks(subject);
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
                        break;
                    case 2:
                        System.out.println("Subject List: ");
                        Path directPathSub = Paths.get("E:\\ProgramInterlij\\com.maven\\Subjects\\");
                        String[] namelistSub = directPathSub.toFile().list();
                        if (namelistSub.length==0){
                            throw new customException("Enter at least one subject");
                        }
                        for (int k = 0; k < namelistSub.length; k++) {
                            System.out.println(namelistSub[k].toString().substring(0, namelistSub[k].length() - 4));

                        }
                        break;
                    case 3:
                        System.out.println("Enter Delete subject: ");
                        String delete = input.next();
                        Path path1 = Paths.get("E:\\ProgramInterlij\\com.maven\\Subjects\\" + delete + ".txt");
                        Map<String, Integer> stdDetails = new HashMap<>();
                        if (path1.toFile().isFile()) {
                            Path directPathStd = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\");
                            String[] namelistStd = directPathStd.toFile().list();
                            for (int i = 0; i < namelistStd.length; i++) {
                                String name = namelistStd[i].toString();
                                Path paths2 = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\" + name);
                                stdDetails = mapper.readValue(paths2.toFile(), Map.class);
                                stdDetails.remove(delete);
                                mapper.writeValue(paths2.toFile(), stdDetails);
                            }
                            Files.delete(path1);

                        } else {
                            System.out.println("no such subject");
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("enter valid input");
                        break;

                }
            }catch (InputMismatchException e){
                System.out.println("enter valid integer input "+e);
            }catch(Exception e){
                System.out.println("Error: "+e);
            }



            }

        }


    }


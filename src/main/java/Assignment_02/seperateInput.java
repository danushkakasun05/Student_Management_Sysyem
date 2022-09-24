package Assignment_02;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class seperateInput{
    public void seperateMarksInput(String name) {
        try{
            Map<String, Integer> maps = new HashMap<>();
            Scanner input= new Scanner(System.in);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Add marks to students");
            Path directPathSub = Paths.get("E:\\ProgramInterlij\\com.maven\\Subjects\\");
            String[] namelistSub = directPathSub.toFile().list();
            if (namelistSub.length == 0) {
                throw new customException("Please enter at least one subject to proceed");
            }
            int mark = 0;
                System.out.println("Enter " + name + " marks of following subjects");
                for (int j = 0; j < namelistSub.length; j++) {
                    String subs = namelistSub[j].toString().substring(0, namelistSub[j].length() - 4);
                    System.out.println("Enter " + subs + " marks");
                    mark = input.nextInt();
                    System.out.println(subs);
                    maps.put(subs, mark);
                }
                System.out.println(maps);
                Path filePath2 = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\" +name+".txt");
                mapper.writeValue(filePath2.toFile(), maps);

            }  catch (customException e) {
            System.out.println(e);
        } catch (Exception e ){
            System.out.println(e);}
    }
    public void seperateSubjectmarks(String sub){
        try {
            Scanner input =new Scanner(System.in);
            Path directPathSub = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\");
            String[] namelistStd = directPathSub.toFile().list();
            Map<String,Integer> maps =new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();
            if (namelistStd.length == 0) {
                throw new customException("Please enter at least one subject to proceed");
            }else{
                for(int k=0; k< namelistStd.length;k++){
                    System.out.println("enter "+namelistStd[k].toString().substring(0,namelistStd[k].length()-4)+" "+sub+" marks");
                    int marks =input.nextInt();
                    Path newpath =Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\"+namelistStd[k].toString().substring(0,namelistStd[k].length()-4)+".txt");
                    maps = mapper.readValue(newpath.toFile(),Map.class);
                    maps.put(sub,marks);
                    mapper.writeValue(newpath.toFile(),maps);

                }
            }
        }catch(customException e){
            System.out.println( e);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

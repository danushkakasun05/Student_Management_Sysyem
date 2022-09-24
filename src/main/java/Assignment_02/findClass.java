package Assignment_02;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findClass {
    public void findClass() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Integer> mapOfMarks= new HashMap<>();
        List<Student> all_student= new ArrayList<>();
        Path directPathStd = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\");
        String [] namelistStd=directPathStd.toFile().list();
        Path directPathSub = Paths.get("E:\\ProgramInterlij\\com.maven\\Subjects\\");
        String [] namelistSub=directPathSub.toFile().list();
        int total=0;
        for(int i=0;i<namelistStd.length;i++){

            total=0;
            String name = namelistStd[i].toString().substring(0,namelistStd[i].length()-4);
            Path pathnew = Paths.get("E:\\ProgramInterlij\\com.maven\\Students\\"+name+".txt");

            mapOfMarks=mapper.readValue(pathnew.toFile(),Map.class);

            for(int j=0;j<mapOfMarks.size();j++){
                total= total+(Integer) mapOfMarks.get(namelistSub[j].toString().substring(0,namelistSub[j].length()-4));
            }
            Student stdNew= new Student(name,total);
            all_student.add(stdNew);

        }

        for (int b = 0; b <all_student.size() - 1; b++) {
            for (int c = b + 1; c < all_student.size(); c++) {
                if (all_student.get(b).getMarks() < all_student.get(c).getMarks()) {
                    Student st1 = new Student();
                    Student st2 = new Student();
                    st1 = all_student.get(b);
                    st2 = all_student.get(c);
                    all_student.set(b, st2);
                    all_student.set(c, st1);


                }
            }
        }
        System.out.println("Student marks list");
        for (int j = 0; j < all_student.size(); j++) {

            System.out.println("Rank "+(j+1)+" "+all_student.get(j).getName());
        }

    }
}

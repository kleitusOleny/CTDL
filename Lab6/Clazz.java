package Lab6;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Clazz {
    private String name;
    private String year;
    private ArrayList<Student> students = new ArrayList<Student>();
    
    public Clazz(String name, String year) {
        this.name = name;
        this.year = year;
    }
    
    //Task 1. load all students form filename into the list of students
    public void loadStudents(String fileName) throws FileNotFoundException {
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            
            String line = bufferedReader.readLine();
            while (line != null){
                String[]data = line.split("\t");
                String id = data[0];
                String lastName = data[1];
                String firstName = data[2];
                LocalDate birthday = LocalDate.parse(data[3]);
                double gpa = Double.parseDouble(data[4]);
                
                Student stu = new Student(id, firstName, lastName, birthday, gpa);
                
                students.add(stu);
                
                line = bufferedReader.readLine();
            }
            
//            for (int i = 0; i < students.size(); i++){
//                System.out.println(students.get(i).toString());
//            }
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void sortStudents(Comparator<Student>c){
        Collections.sort(this.students, c);
    }
    
    public List<Student> getTopNStudents(int n){
        List<Student> res = new ArrayList<>();
        Comparator<Student> c = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getGPA() > o2.getGPA()){
                    return 1;
                }else{
                    return -1;
                }
            }};
            sortStudents(c);
            for (int i = 0; i < n; i++){
                res.add(students.get(i));
            }
        return res;
    }
    
    public ArrayList<Student> getRandomNStudents(int n){
        ArrayList<Student> res = new ArrayList<>();
        
        Collections.shuffle(this.students);
        
        for (int i = 0; i < students.size(); i++){
            res.add(students.get(i));
        }
        return res;
    }
    //Task5
    public boolean removeStudent(String id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    
    //Task 6
    public ArrayList<Student>getStudentByBirthYear(int birthYear){
        ArrayList<Student> res = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getBirthday().getYear() == birthYear){
                res.add(students.get(i));
            }
        }
        return res;
    }
    
    public ArrayList<Student> getStudentsHavingBirthdaysCurrentMonth() {
        ArrayList<Student> res = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getBirthday().getMonth() == LocalDate.now().getMonth()){
                res.add(students.get(i));
            }
        }
        return res;
    }
    
    public Student getOldestStudent(){
        Student stu = students.get(0);
        int year = students.get(0).getBirthday().getYear();
        for (int i = 1; i < students.size(); i++) {
            if (year < students.get(i).getBirthday().getYear()){
                year = students.get(i).getBirthday().getYear();
                stu = students.get(i);
            }
        }
        return stu;
    }
    
    public Student getHighestGPAStudent(){
        Student stu = students.get(0);
        double highest = students.get(0).getGPA();
        for (int i = 0; i < students.size(); i++) {
            if (highest < students.get(i).getGPA()){
                highest = students.get(i).getGPA();
                stu = students.get(i);
            }
        }
        return stu;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        String url = "./data/students.txt";
        Clazz cls = new Clazz("DT","2023");
        cls.loadStudents(url);
        
//        int n = 2;
//        ArrayList<Student>arr = new ArrayList<Student>(cls.getRandomNStudents(n));
//        for (int i = 0; i < n; i++) {
//            System.out.println(arr.get(i).toString());
//        }
        
        
    }
}

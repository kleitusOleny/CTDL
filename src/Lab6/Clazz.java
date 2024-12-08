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
    public void loadStudents(String fileName) throws IOException {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] data = line.split("\t");
                String id = data[0];
                String lastName = data[1];
                String firstName = data[2];
                LocalDate birthday = LocalDate.parse(data[3]);
                double gpa = Double.parseDouble(data[4]);
                
                Student stu = new Student(id, firstName, lastName, birthday, gpa);
                
                students.add(stu);
                
                line = bufferedReader.readLine();
            }
            
            bufferedReader.close();
    }
    
    // Task 2. sort students according to the given comparator c
    public void sortStudents(Comparator<Student> c) {
        Collections.sort(this.students, c);
    }
    
    // Task 3. get top n students with highest GPA
    public List<Student> getTopNStudents(int n) {
        List<Student> res = new ArrayList<>();
        Comparator<Student> c = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGPA() < o2.getGPA()) return 1;
                else return -1;
            }
        };
        
        sortStudents(c);
        for (int i = 0; i < n; i++) {
            res.add(students.get(i));
        }
        return res;
    }
    // Task 4. get random n students from the list of students
    public ArrayList<Student> getRandomNStudents(int n) {
        ArrayList<Student> res = new ArrayList<>();
        
        Collections.shuffle(this.students);
        
        for (int i = 0; i < n; i++) {
            res.add(students.get(i));
        }
        return res;
    }
    
    // Task 5. remove a student based on a given id
    public boolean removeStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
          if (students.get(i).isID(id)){
              students.remove(i);
              return true;
          }
        }
        return false;
    }
    
    // Task 6. get all students who were born in a given birth year.
    public ArrayList<Student> getStudentByBirthYear(int birthYear) {
        ArrayList<Student> res = new ArrayList<Student>();
        for (Student student : students){
            if (student.inBirthYear(birthYear)){
                res.add(student);
            }
        }
        return res;
    }
    
    // Task 7. get all students who have birthdays in the current month (i.e., November).
    public ArrayList<Student> getStudentsHavingBirthdaysCurrentMonth() {
        ArrayList<Student> res = new ArrayList<Student>();
        for (Student student : students){
            if (student.isBirthDayInMonth()){
                res.add(student);
            }
        }
        return res;
    }

    // Task 9. get the oldest student based on the birth year.
    public Student getOldestStudent() {
        Student stu = students.get(0);
        int year = students.get(0).getBirthday().getYear();
        for (int i = 1; i < students.size(); i++) {
            if (year > students.get(i).getBirthday().getYear()) {
                year = students.get(i).getBirthday().getYear();
                stu = students.get(i);
            }
        }
        return stu;
    }
    
    // Task 10. get the student having the highest GPA based on a given admission year.
    public Student getHighestGPAStudent(int year) {
        ArrayList<Student> list = new ArrayList<>();
        String yearAdmission = String.valueOf(year).substring(2);
        for (Student stu : students) {
            if (stu.getId().startsWith(yearAdmission))
                list.add(stu);
        }
       Student stuHighestGPAinYear = list.getFirst();
       for (Student stu : list){
            if (stuHighestGPAinYear.getGPA() < stu.getGPA()){
                stuHighestGPAinYear = stu;
            }
       }
        return stuHighestGPAinYear;
    }
    
    public static void main(String[] args) throws IOException {
        String url = "data/students.txt";
        Clazz cls = new Clazz("DT", "2023");
        cls.loadStudents(url);
        
        System.out.println("///Test Task 2///");
        Comparator<Student>c = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getGPA() < o2.getGPA())return 1;
                else return -1;
            }
        };
        cls.sortStudents(c);
        for (Student stu : cls.students){
            System.out.println(stu.toString());
        }

        ArrayList<Student> listStu;
        cls = new Clazz("DT", "2023");
        cls.loadStudents(url);
        System.out.println("///Test Task 3///");
        listStu = new ArrayList<Student>(cls.getTopNStudents(3));
        for (Student stu : listStu){
            System.out.println(stu.toString());
        }

        System.out.println("///Test Task 4///");
        cls = new Clazz("DT", "2023");
        cls.loadStudents(url);
        listStu = new ArrayList<Student>(cls.getRandomNStudents(3));
        for (Student stu : listStu){
            System.out.println(stu.toString());
        }

        System.out.println("///Test Task 5///");
        cls = new Clazz("DT", "2023");
        cls.loadStudents(url);
        String id = "19130006";
        System.out.println(cls.removeStudent(id));
        for (Student stu : cls.students){
            System.out.println(stu.toString());
        }

        System.out.println("///Test Task 6///");
        cls = new Clazz("DT", "2023");
        cls.loadStudents(url);
        listStu = new ArrayList<Student>(cls.getStudentByBirthYear(1997));
        for (Student stu : listStu){
            System.out.println(stu.toString());
        }
        
        System.out.println("///Test Task 7///");
        cls = new Clazz("DT", "2023");
        cls.loadStudents(url);
        listStu = new ArrayList<Student>(cls.getStudentsHavingBirthdaysCurrentMonth());
        for (Student stu : listStu){
            System.out.println(stu.toString());
        }
        
        System.out.println("///Test Task 9///");
        cls = new Clazz("DT", "2023");
        cls.loadStudents(url);
        System.out.println(cls.getOldestStudent().toString());

        System.out.println("///Test Task 10///");
        cls = new Clazz("DT", "2023");
        cls.loadStudents(url);
        System.out.println(cls.getHighestGPAStudent(2021));
    }
}


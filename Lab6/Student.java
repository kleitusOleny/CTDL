package Lab6;

import java.time.LocalDate;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private double GPA;
    
    public Student(String id, String firstName, String lastName, LocalDate birthday, double GPA) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.GPA = GPA;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", GPA=" + GPA +
                '}';
    }
    
    public double getGPA() {
        return GPA;
    }
    
    public String getId() {
        return id;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
}

package Lab6;

import java.time.LocalDate;

public class Student {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final double GPA;
    
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
    
    public boolean isID(String id) {
        return this.id.equals(id);
    }
    
    public boolean inBirthYear(int birthYear) {
        return this.birthday.getYear() == birthYear;
    }
    
    public boolean isBirthDayInMonth() {
        return this.birthday.getMonth() == LocalDate.now().getMonth();
    }
}

package Lab1_Task2;

public class Student {
    private String id;
    private String name;
    private int year;
    public Student(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }
}

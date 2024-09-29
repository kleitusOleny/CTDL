package Lab1_Task2;

public class Course {
    private String id;
    private String title;
    private String type;
    private Student[] students;
    private String lecturer;
    public Course(String id,String title,String type,Student[] students ,String lecturer) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = students;
        this.lecturer = lecturer;
    }

    public boolean containsName(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(student.getName())) {
                return true;
            }
        }
        return false;
    }

}

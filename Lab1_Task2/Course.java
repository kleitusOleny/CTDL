package Lab1_Task2;

public class Course {
    private String id;
    private String title;
    private String type;
    private Student[] students;
    private String lecturer;

    public Course(String id, String title, String type, Student[] students, String lecturer) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = students;
        this.lecturer = lecturer;
    }

    public String getId() {
        return id;
    }

    public String getLecturer() {
        return lecturer;
    }

    public boolean containsName(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId().equals(student.getId())) {
                return true;
            }
        }
        return false;
    }

    public Student[] countStudentByYear(int year) {
        Student[] listStudents = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
            if (students[i].getYear() == year) {
                listStudents[i] = students[i];
            }
        }
        return listStudents;
    }

    public int countStudent() {
        int result = 0;
        for (int i = 0; i < students.length; i++) {
            result++;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + ", type=" + type + ", students=" + this.students.toString() + ", lecturer=" + this.lecturer + "]";
    }

}

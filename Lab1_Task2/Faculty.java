package Lab1_Task2;

public class Faculty {
    private String name;
    private String address;
    private Course[] course;
    public Faculty(String name,Course[] course, String address) {
        this.name = name;
        this.course = course;
        this.address = address;
    }

    //check whether a given student is enrolled in a course.
    public boolean checkStudentInCourse(Student student) {
        boolean result = false;
        for(int i = 0; i < course.length; i++) {
            result = course[i].containsName(student);
        }
        return result;
    }

    public static void main(String[] args) {
        Student student1 = new Student("23130383","Nguyen Phu Vinh",2023);
        Student student2 = new Student("1111","A",2023);
        Student student3 = new Student("2222","B",2023);
        Student[] listStudent = new Student[]{student1,student2};
        Course course1 = new Course("001","A","Math", listStudent,"D");
        Course course2 = new Course("002","B","Math", listStudent,"D");
        Course[]listCourse = new Course[]{course1,course2};
        Faculty faculty = new Faculty("IT",listCourse,"RD");
        System.out.println(faculty.checkStudentInCourse(student3));
    }
}

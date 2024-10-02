package Lab1_Task2;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final String name;
    private final String address;
    private final Course[] courses;

    public Faculty(String name, Course[] courses, String address) {
        this.name = name;
        this.courses = courses;
        this.address = address;
    }

    //check whether a given student is enrolled in a course.
    public boolean checkStudentInCourse(Student student) {
        boolean result = false;
        for (int i = 0; i < courses.length; i++) {
            result = courses[i].containsName(student);
        }
        return result;
    }

    public int numberStudentInCourse(Course course,int year) {
        int result = 0;
        for (int i = 0; i < courses.length; i++) {
            if(course.getId().equals(courses[i].getId())) {
                result = courses[i].countStudentByYear(year).length;
            }
        }
        return result;
    }

    public int numberStudentsInFaculty(int year) {
        List<String> listIDStudents = new ArrayList<>(1);
        for (int i = 0; i < courses.length; i++) {
            for (int j = 0; j < courses[i].countStudentByYear(year).length; j++) {
                if (!listIDStudents.contains(courses[i].countStudentByYear(year)[j].getId())) {
                    listIDStudents.add(courses[i].countStudentByYear(year)[j].getId());
                }
            }
        }
        return listIDStudents.size();
    }

    public Course getHighestCourses() {
        Course result = null;
        List<Integer> courseList = new ArrayList<>();
        for (int i = 0; i < courses.length; i++) {
            courseList.add(courses[i].countStudent());
        }
        for (int i = 0; i < courseList.size() - 1; i++) {
            if (courseList.get(i) > courseList.get(i + 1)) {
                result = courses[i];
            }else{
                result = courses[i + 1];
            }
        }
        return result;
    }

    public List<Course> getCoursesByLecturer(String lecturerName) {
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getLecturer().equals(lecturerName)){
                System.out.println();
                result.add(courses[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Student student1 = new Student("23130383", "Nguyen Phu Vinh", 2023);
        Student student2 = new Student("1111", "A", 2023);
        Student student3 = new Student("2222", "B", 2023);
        Student student4 = new Student("3333", "A", 2023);
        Student[] listStudent = new Student[]{student1, student2,student4};
        Student[] listStudent2 = new Student[]{student3, student2};
        Student[] listStudent3 = new Student[]{student3, student1};
        Course course1 = new Course("001", "A", "Math", listStudent, "D");
        Course course2 = new Course("002", "B", "Math", listStudent2, "D");
        Course[] listCourse = new Course[]{course1, course2};
        Faculty faculty = new Faculty("IT", listCourse, "RD");
        System.out.println(faculty.checkStudentInCourse(student3));
        System.out.println(faculty.numberStudentInCourse(course1, 2023));
        System.out.println(faculty.numberStudentsInFaculty(2023));
        System.out.println(faculty.getHighestCourses().toString());
        System.out.println(faculty.getCoursesByLecturer("D").toString());
    }
}

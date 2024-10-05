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

    //Implement a method (named contains) to check whether a given student is enrolled in
    //a course.
    public boolean checkStudentInCourse(Student student) {
        boolean result = false;
        for (int i = 0; i < courses.length; i++) {
            result = courses[i].containsName(student);
        }
        return result;
    }

    //Count the number of students enrolled in each course based on a given year.
    public int numberStudentInCourse(Course course,int year) {
        int result = 0;
        for (int i = 0; i < courses.length; i++) {
            if(course.getId().equals(courses[i].getId())) {
                result = courses[i].countStudentByYear(year).length;
            }
        }
        return result;
    }
    //Count the number of students in a faculty based on a given year. Notice that, a student
    //can enroll in more than one course.
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
    //Find the course with the highest number of enrolled students.
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

    //Get all courses taught by a given lecturer.
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
}

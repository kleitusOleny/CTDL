package Lab1_Task2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class Test extends TestCase{

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

    public void testCheckStudentInCourse(){
        assertEquals(faculty.checkStudentInCourse(student3),true);
    }
    public void testNumberStudentInCourse(){
        assertEquals(faculty.numberStudentInCourse(course1, 2023),3);
    }
    public void testNumberStudentsInFaculty(){
        assertEquals(faculty.numberStudentsInFaculty(2023),4);
    }
    public void testGetHighestCourses(){
        assertEquals(faculty.getHighestCourses(),course1);
    }
    public void testGetCoursesByLecturer(){
        List<Course> courseList = new ArrayList<Course>();
        courseList.add(course1);
        courseList.add(course2);
        assertEquals(faculty.getCoursesByLecturer("D"),courseList);
    }

}

package Lab1_Task2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class Test extends TestCase{

    Student student1 = new Student("23130383", "Nguyen Phu Vinh", 2023);
    Student student2 = new Student("1111", "A", 2023);
    Student student3 = new Student("2222", "B", 2023);
    Student student4 = new Student("3333", "C", 2024);
    Student[] listStudent = new Student[]{student1, student2,student4};
    Student[] listStudent2 = new Student[]{student3, student2};
    Student[] listStudent3 = new Student[]{student3, student1};
    Course course1 = new Course("001", "A", "Math", listStudent, "D");
    Course course2 = new Course("002", "B", "Physical", listStudent2, "D");
    Course course3 = new Course("003", "C", "Math", listStudent3, "E");
    Course[] listCourse = new Course[]{course1, course2};
    Course[] listCourse2 = new Course[]{course3, course1};
    Faculty faculty = new Faculty("IT", listCourse, "RD");
    Faculty faculty2 = new Faculty("CNSH", listCourse2, "CT");

    public void testCheckStudentInCourse(){
        assertEquals(faculty.checkStudentInCourse(student3),true);
        assertEquals(faculty2.checkStudentInCourse(student3),false);
    }

    public void testNumberStudentInCourse(){
        assertEquals(faculty.numberStudentInCourse(course1, 2023),3);
        assertEquals(faculty2.numberStudentInCourse(course3, 2023),2);
    }

    public void testNumberStudentsInFaculty(){
        assertEquals(faculty.numberStudentsInFaculty(2023),4);
        assertEquals(faculty2.numberStudentsInFaculty(2023),3);
    }

    public void testGetHighestCourses(){
        assertEquals(faculty.getHighestCourses(),course1);
        assertEquals(faculty2.getHighestCourses(),course1);
    }

    public void testGetCoursesByLecturer(){
        List<Course> courseList1 = new ArrayList<Course>();
        courseList1.add(course1);
        courseList1.add(course2);
        List<Course> courseList2 = new ArrayList<Course>();
        courseList2.add(course3);

        assertEquals(faculty.getCoursesByLecturer("D"), courseList1);
        assertEquals(faculty2.getCoursesByLecturer("E"), courseList2);
    }
}

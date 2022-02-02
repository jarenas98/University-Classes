package co.globant.academy.finalexercise.business;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;
    private int id;
    private static int count = 1;

    public University() {
        this.courses = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.id = count;
        count++;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addStudentToCourse(int idStudent, int idCourse) {
        Student foundStudent = getStudentById(idStudent);
        if(foundStudent.getName() != null) getCourseById(idCourse).addStudent(foundStudent);

    }

    public Student getStudentById(int idStudent) {
        Student foundStudent = new Student();
        for (Student student : this.students) {
            if (idStudent == student.getId()) {

                foundStudent = student;
            }
        }

        return foundStudent;
    }

    public Course getCourseById(int idCourse) {
        Course courseAux = new Course();
        for (Course course : this.courses) {
            if (idCourse == course.getId()) {

                courseAux = course;
            }
        }

        return courseAux;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        List<Course> studentCourses = new ArrayList<>();
        for (Course course : this.courses) {
            if (course.isStudentEnrolledById(studentId)) studentCourses.add(course);
        }

        return studentCourses;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        return this.teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return this.id;
    }

}

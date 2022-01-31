package co.globant.academy.finalexercise.business;

import java.util.List;

public class University {
    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;
    private int id;
    private static int count = 1;

    public University() {
        this.id = count;
        count++;
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

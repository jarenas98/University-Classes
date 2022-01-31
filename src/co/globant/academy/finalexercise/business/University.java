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

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addStudentToCourse(int idStudent, int idCourse) {
        getCourseById(idCourse).addStudent(getStudentById(idStudent));
    }

    public Student getStudentById(int idStudent) {
        for (Student student : this.students) {
            if (idStudent == student.getId()) {

                return student;
            }
        }

        return null;
    }

    public Course getCourseById(int idCourse) {
        for (Course course : this.courses) {
            if (idCourse == course.getId()) {

                return course;
            }
        }

        return null;
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

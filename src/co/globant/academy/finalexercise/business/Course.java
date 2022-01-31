package co.globant.academy.finalexercise.business;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private String assignedClassroom;
    private List<Student> students;
    private Teacher teacher;
    private int id;
    private static int count = 1;

    public Course() {
        this.students = new ArrayList<>();
        this.id = count;
        count++;
    }

    public Course(String name) {
        this.students = new ArrayList<>();
        this.name = name;
        this.id = count;
        count++;
    }

    public Course(String name, String assignedClassroom) {
        this.students = new ArrayList<>();
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.id = count;
        count++;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignedClassroom() {
        return this.assignedClassroom;
    }

    public void setAssignedClassroom(String assignedClassroom) {
        this.assignedClassroom = assignedClassroom;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }
}

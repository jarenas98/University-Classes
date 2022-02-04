package co.globant.academy.finalexercise.business;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private String assignedClassroom;
    private List<Student> studentList;
    private Teacher teacher;
    private int id;
    private static int count = 1;

    public Course() {
        this.studentList = new ArrayList<>();
        this.id = count;
        count++;
    }

    public Course(String name) {
        this.studentList = new ArrayList<>();
        this.name = name;
        this.id = count;
        count++;
    }

    public Course(String name, String assignedClassroom) {
        this.studentList = new ArrayList<>();
        this.name = name;
        this.assignedClassroom = assignedClassroom;
        this.id = count;
        count++;
    }

    public boolean isStudentEnrolledById(int studentId) {
        boolean isEnrolled = false;
        for (Student student : this.studentList) {
            if (student.getId() == studentId) isEnrolled = true;
        }

        return isEnrolled;
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
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

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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

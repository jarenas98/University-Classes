package co.globant.academy.finalexercise.data;

import co.globant.academy.finalexercise.business.*;

import java.util.ArrayList;
import java.util.List;

public class DummyDataInitializer {

    // University
    private University university = new University();

    // Students
    private Student st1 = new Student("Juan Felipe", (short) 16);
    private Student st2 = new Student("Jessica", (short) 17);
    private Student st3 = new Student("Ulises", (short) 18);
    private Student st4 = new Student("Danilo Andres", (short) 19);
    private Student st5 = new Student("Luisa Fernanda", (short) 18);
    private Student st6 = new Student("Camilo Alejandro", (short) 17);
    private Student st7 = new Student("Diego Fernando", (short) 16);
    private Student st8 = new Student("Luis Daniel", (short) 15);

    // Teachers

    /// full time teachers
    private FullTimeTeacher ftt1 = new FullTimeTeacher("Faber", 1100, (short) 15);
    private FullTimeTeacher ftt2 = new FullTimeTeacher("Edwin", 800, (short) 20);
    private FullTimeTeacher ftt3 = new FullTimeTeacher("Andres", 1000, (short) 7);
    /// part-time teachers
    private PartTimeTeacher ptt1 = new PartTimeTeacher("Jesus", 15, (short) 44);
    private PartTimeTeacher ptt2 = new PartTimeTeacher("Maycol", 18, (short) 44);
    private PartTimeTeacher ptt3 = new PartTimeTeacher("Andrea", 20, (short) 44);

    // Courses
    private Course c1 = new Course("Big Data", "S-23");
    private Course c2 = new Course("Data Analytics", "S-24");
    private Course c3 = new Course("IA", "S-25");
    private Course c4 = new Course("Clean Code", "S-26");

    // lists
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public DummyDataInitializer() {
        // add students to a list
        this.students.add(st1);
        this.students.add(st2);
        this.students.add(st3);
        this.students.add(st4);
        this.students.add(st5);
        this.students.add(st6);
        this.students.add(st7);
        this.students.add(st8);

        // add teacher to a list
        this.teachers.add(ftt1);
        this.teachers.add(ftt2);
        this.teachers.add(ftt3);
        this.teachers.add(ptt1);
        this.teachers.add(ptt2);
        this.teachers.add(ptt3);

        // add courses to a list
        this.courses.add(c1);
        this.courses.add(c2);
        this.courses.add(c3);
        this.courses.add(c4);


        // add students and teachers to courses
        this.c1.addStudent(st1);
        this.c1.addStudent(st2);
        this.c1.setTeacher(ftt1);

        this.c2.addStudent(st3);
        this.c2.addStudent(st4);
        this.c2.setTeacher(ftt2);

        this.c3.addStudent(st5);
        this.c3.addStudent(st6);
        this.c3.setTeacher(ptt1);

        this.c4.addStudent(st7);
        this.c4.addStudent(st8);
        this.c4.setTeacher(ptt2);

        // add list to university
        this.university.setTeachers(this.teachers);
        this.university.setCourses(this.courses);
        this.university.setStudents(this.students);
    }

    public University getUniversity() {
        return university;
    }
}

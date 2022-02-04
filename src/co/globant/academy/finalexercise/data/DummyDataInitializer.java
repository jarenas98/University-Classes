package co.globant.academy.finalexercise.data;

import co.globant.academy.finalexercise.business.*;

import java.util.ArrayList;
import java.util.List;

public class DummyDataInitializer {

    // University
    private University university = new University();

    // Students
    private Student student_juan_felipe = new Student("Juan Felipe", (short) 16);
    private Student student_jessica = new Student("Jessica", (short) 17);
    private Student student_ulises = new Student("Ulises", (short) 18);
    private Student student_danilo_andres = new Student("Danilo Andres", (short) 19);
    private Student student_luisa_fernanda = new Student("Luisa Fernanda", (short) 18);
    private Student student_camilo_alejandro = new Student("Camilo Alejandro", (short) 17);
    private Student student_diego_fernando = new Student("Diego Fernando", (short) 16);
    private Student student_luis_daniel = new Student("Luis Daniel", (short) 15);

    // Teachers

    /// full time teachers
    private FullTimeTeacher teacher_faber = new FullTimeTeacher("Faber", 1100, (short) 15);
    private FullTimeTeacher teacher_edwin = new FullTimeTeacher("Edwin", 800, (short) 20);
    private FullTimeTeacher teacher_andres = new FullTimeTeacher("Andres", 1000, (short) 7);
    /// part-time teachers
    private PartTimeTeacher teacher_jesus = new PartTimeTeacher("Jesus", 15, (short) 44);
    private PartTimeTeacher teacher_maycol = new PartTimeTeacher("Maycol", 18, (short) 44);
    private PartTimeTeacher teacher_andrea = new PartTimeTeacher("Andrea", 20, (short) 44);

    // Courses
    private Course big_data_course = new Course("Big Data", "S-23");
    private Course data_analytics_course = new Course("Data Analytics", "S-24");
    private Course ia_course = new Course("IA", "S-25");
    private Course clean_code_course = new Course("Clean Code", "S-26");

    // lists
    private List<Student> studentsList = new ArrayList<>();
    private List<Teacher> teachersList = new ArrayList<>();
    private List<Course> coursesList = new ArrayList<>();

    public DummyDataInitializer() {
        // add students to a list
        this.studentsList.add(student_juan_felipe);
        this.studentsList.add(student_jessica);
        this.studentsList.add(student_ulises);
        this.studentsList.add(student_danilo_andres);
        this.studentsList.add(student_luisa_fernanda);
        this.studentsList.add(student_camilo_alejandro);
        this.studentsList.add(student_diego_fernando);
        this.studentsList.add(student_luis_daniel);

        // add teacher to a list
        this.teachersList.add(teacher_faber);
        this.teachersList.add(teacher_edwin);
        this.teachersList.add(teacher_andres);
        this.teachersList.add(teacher_jesus);
        this.teachersList.add(teacher_maycol);
        this.teachersList.add(teacher_andrea);

        // add courses to a list
        this.coursesList.add(big_data_course);
        this.coursesList.add(data_analytics_course);
        this.coursesList.add(ia_course);
        this.coursesList.add(clean_code_course);


        // add students and teachers to courses
        this.big_data_course.addStudent(student_juan_felipe);
        this.big_data_course.addStudent(student_jessica);
        this.big_data_course.setTeacher(teacher_faber);

        this.data_analytics_course.addStudent(student_ulises);
        this.data_analytics_course.addStudent(student_danilo_andres);
        this.data_analytics_course.setTeacher(teacher_edwin);

        this.ia_course.addStudent(student_luisa_fernanda);
        this.ia_course.addStudent(student_camilo_alejandro);
        this.ia_course.setTeacher(teacher_jesus);

        this.clean_code_course.addStudent(student_diego_fernando);
        this.clean_code_course.addStudent(student_luis_daniel);
        this.clean_code_course.setTeacher(teacher_maycol);

        // add list to university
        this.university.setTeacherList(this.teachersList);
        this.university.setCourseList(this.coursesList);
        this.university.setStudentList(this.studentsList);
    }

    public University getUniversity() {
        return university;
    }
}

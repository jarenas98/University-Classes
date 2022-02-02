package co.globant.academy.finalexercise.business;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Course> courseList;
    private List<Teacher> teacherList;
    private List<Student> studentList;
    private int id;
    private static int count = 1;

    public University() {
        this.courseList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.id = count;
        count++;
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
    }

    public void addStudentToCourse(int idStudent, int idCourse) {
        Student foundStudent = getStudentById(idStudent);
        Course foundCourse = getCourseById(idCourse);
        if (foundCourse.getName() != null &&
                foundStudent.getName() != null &&
                !foundCourse.isStudentEnrolledById(idStudent)) {
            foundCourse.addStudent(foundStudent);
        }

    }

    public Student getStudentById(int idStudent) {
        Student foundStudent = new Student();
        for (Student student : this.studentList) {
            if (idStudent == student.getId()) {

                foundStudent = student;
            }
        }

        return foundStudent;
    }

    public Course getCourseById(int idCourse) {
        Course courseAux = new Course();
        for (Course course : this.courseList) {
            if (idCourse == course.getId()) {

                courseAux = course;
            }
        }

        return courseAux;
    }

    public Teacher getTeacherById(int teacherId){
        Teacher foundTeacher = new FullTimeTeacher();
        for (Teacher teacher: this.teacherList) {
            if (teacher.getId() == teacherId){
                foundTeacher = teacher;
            }
        }

        return foundTeacher;
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        List<Course> studentCourses = new ArrayList<>();
        for (Course course : this.courseList) {
            if (course.isStudentEnrolledById(studentId)) studentCourses.add(course);
        }

        return studentCourses;
    }

    public boolean isThereCourseById(int courseId) {
        boolean isThereCourse = false;
        for (Course course : this.courseList) {
            if (course.getId() == courseId) isThereCourse = true;
        }

        return isThereCourse;
    }

    public boolean isThereTeacherById(int teacherId) {
        boolean isThereTeacher = false;
        for (Teacher teacher : this.teacherList) {
            if (teacher.getId() == teacherId) isThereTeacher = true;
        }

        return isThereTeacher;
    }

    public boolean isThereStudentById(int studentId) {
        boolean isThereStudent = false;
        for (Student student: this.studentList) {
            if (student.getId() == studentId){
                isThereStudent = true;
            }
        }

        return isThereStudent;
    }

    public void setTeacherOfCourse(int courseId, int teacherId) {
        Teacher foundTeacher = getTeacherById(teacherId);
        Course foundCourse = getCourseById(courseId);
        if(foundCourse.getName() != null && foundTeacher.getName() != null){
            foundCourse.setTeacher(foundTeacher);
        }
    }

    public List<Course> getCourseList() {
        return this.courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Teacher> getTeacherList() {
        return this.teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getId() {
        return this.id;
    }

}

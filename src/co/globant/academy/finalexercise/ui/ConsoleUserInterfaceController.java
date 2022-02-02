package co.globant.academy.finalexercise.ui;

import co.globant.academy.finalexercise.business.Course;
import co.globant.academy.finalexercise.business.Student;
import co.globant.academy.finalexercise.business.Teacher;
import co.globant.academy.finalexercise.business.University;
import co.globant.academy.finalexercise.data.DummyDataInitializer;

import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterfaceController {

    private DummyDataInitializer dummyDataInitializer;
    private University university;
    private Scanner sc = new Scanner(System.in);

    public ConsoleUserInterfaceController() {
        this.dummyDataInitializer = new DummyDataInitializer();
        this.university = this.dummyDataInitializer.getUniversity();

    }

    public void seeMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("==================================================");
            System.out.printf("%35s \n", "Main Menu University");
            System.out.println("==================================================");
            System.out.println("Select one of the following options:");
            System.out.println("--------------------------------------------------");
            System.out.printf("%14s %20s \n", "(1)", "Print all the Teacher");
            System.out.printf("%14s %20s \n", "(2)", "Print all the classes");
            System.out.printf("%14s %20s \n", "(3)", "Create a new student");
            System.out.printf("%14s %15s \n", "(4)", "Create a new class");
            System.out.printf("%14s %20s \n", "(5)", "Student's class list");
            System.out.printf("%14s %4s \n", "(6)", "Exit");
            System.out.println("--------------------------------------------------");
            System.out.print("Enter the value: ");
            int option = sc.nextInt();
            if (option == 6) {
                exit = true;
            } else {
                mainMenuController(option);
            }
        }
    }

    public void mainMenuController(int option) {
        switch (option) {
            case 1:
                seeTeacherMenu();
                break;
            case 2:
                seeCoursesListMenu();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                seeStudentCoursesList();
                break;
            default:
                break;
        }
    }

    public void seeTeacherMenu() {
        System.out.println("===============================================================");
        System.out.printf("%35s \n", "University Teachers");
        System.out.println("===============================================================");
        System.out.printf("%3s %8s %5s %8s %5s %8s %8s\n", "id", "Name", "", "Base Salary", "", "Full Salary", "Type");
        System.out.println("---------------------------------------------------------------");
        List<Teacher> teachers = this.university.getTeachers();
        for (Teacher teacher : teachers) {
            String type = (teacher.getClass().getSimpleName().equals("FullTimeTeacher")) ? "Full Time" : "Part Time";
            System.out.printf("%3s %8s %5s %8.2f %7s %10.2f %12s\n", teacher.getId(), teacher.getName(), "$", teacher.getBaseSalary(), "$", teacher.calculateSalary(), type);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter any value to return to the main menu : ");
        sc.next();
    }

    public void seeCoursesListMenu() {
        printListOfCourses(this.university.getCourses(), "University");
        System.out.println("---------------------------------------------------------------");
        System.out.println("do you want to see the details of a class?:");
        System.out.printf("%24s\n%29s\n", "(1) Yes", "(2) No, back");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter the value: ");
        int option = sc.nextInt();
        if (option == 1) {
            coursesListMenuController();
        } else if (option != 2) {
            System.err.println("The value entered is not valid");
            seeCoursesListMenu();
        }
    }

    public void coursesListMenuController() {
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter the class id: ");
        int option = sc.nextInt();
        Course course = this.university.getCourseById(option);
        if (course.getName() != null) {
            System.out.println("===============================================================");
            System.out.printf("%35s \n", "Class Info");
            System.out.println("===============================================================");
            System.out.printf("%s %s\t %s\n", "Name", "=", course.getName());
            System.out.printf("%s %s\t %s\n", "Teacher", "=", course.getTeacher().getName());
            printListOfStudents(course.getStudents());
        } else {
            System.err.println("The entered id does not belong to any registered class");
        }
        System.out.println("===============================================================");
        seeMenuToGoBack();
        seeCoursesListMenu();
    }

    public void printListOfStudents(List<Student> students) {
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%40s \n", " Students");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%18s %18s %5s\n", "id", "Name", "age");
        System.out.println("---------------------------------------------------------------");
        for (Student student : students) {
            System.out.printf("%18s %18s %5s\n", student.getId(), student.getName(), student.getAge());
        }
    }

    public void seeStudentCoursesList() {
        printListOfStudents(this.university.getStudents());
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter the id of the student you want to know\nthe courses he/she is enrolled in : ");
        int idStudent = sc.nextInt();
        Student foundStudent = this.university.getStudentById(idStudent);
        if (foundStudent.getName() != null) {
            List<Course> studentCourses = this.university.getCoursesByStudentId(idStudent);
            printListOfCourses(studentCourses, foundStudent.getName());
        } else {
            System.err.println("\nThe entered id does not belong to any registered student");
        }
        seeMenuToGoBack();
    }

    public void printListOfCourses(List<Course> coursesList, String label) {
        System.out.println("===============================================================");
        System.out.printf("%35s \n", label + " Classes");
        System.out.println("===============================================================");
        System.out.printf("%20s %15s\n", "id", "Name");
        System.out.println("---------------------------------------------------------------");
        for (Course course : coursesList) {
            System.out.printf("%20s %15s\n", course.getId(), course.getName());
        }
        System.out.println("---------------------------------------------------------------");
    }

    public void seeMenuToGoBack() {
        System.out.print("Enter any value to go back : ");
        sc.next();
    }
}

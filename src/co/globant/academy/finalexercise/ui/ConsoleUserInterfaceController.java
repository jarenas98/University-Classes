package co.globant.academy.finalexercise.ui;

import co.globant.academy.finalexercise.business.Course;
import co.globant.academy.finalexercise.business.Teacher;
import co.globant.academy.finalexercise.data.DummyDataInitializer;

import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterfaceController {

    private DummyDataInitializer dummyDataInitializer;
    private Scanner sc = new Scanner(System.in);

    public ConsoleUserInterfaceController() {
        this.dummyDataInitializer = new DummyDataInitializer();
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
        List<Teacher> teachers = this.dummyDataInitializer.getUniversity().getTeachers();
        for (Teacher teacher : teachers) {
            String type = (teacher.getClass().getSimpleName().equals("FullTimeTeacher"))? "Full Time":"Part Time";
            System.out.printf("%3s %8s %5s %8.2f %7s %10.2f %12s\n", teacher.getId(), teacher.getName(), "$", teacher.getBaseSalary(), "$", teacher.calculateSalary(), type);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter any value to return to the main menu : ");
        sc.next();
    }

    public void seeCoursesListMenu(){
        System.out.println("===============================================================");
        System.out.printf("%35s \n", "University Classes");
        System.out.println("===============================================================");
        System.out.printf("%20s %15s\n", "id", "Name");
        System.out.println("---------------------------------------------------------------");
        List<Course> courses = this.dummyDataInitializer.getUniversity().getCourses();
        for (Course course: courses) {
            System.out.printf("%20s %15s\n", course.getId(), course.getName());
        }
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter any value to return to the main menu : ");
        sc.next();
    }
}

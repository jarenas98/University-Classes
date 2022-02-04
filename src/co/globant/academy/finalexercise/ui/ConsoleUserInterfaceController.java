package co.globant.academy.finalexercise.ui;

import co.globant.academy.finalexercise.business.Course;
import co.globant.academy.finalexercise.business.Student;
import co.globant.academy.finalexercise.business.Teacher;
import co.globant.academy.finalexercise.business.University;
import co.globant.academy.finalexercise.data.DummyDataInitializer;

import java.util.InputMismatchException;
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
            try {
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
            } catch (InputMismatchException ime) {
                cleanScanner();
                System.out.println("---------------------------------------------------------------");
                System.out.println("The value entered is not valid,\nyou will be redirected to the main menu.");
                System.out.println("---------------------------------------------------------------");
                seeMenuToGoBack();
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
                seeStudentCreationMenu();
                break;
            case 4:
                seeCourseCreationMenu();
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
        List<Teacher> teachers = this.university.getTeacherList();
        for (Teacher teacher : teachers) {
            String type = (teacher.getClass().getSimpleName().equals("FullTimeTeacher")) ? "Full Time" : "Part Time";
            System.out.printf("%3s %8s %5s %8.2f %7s %10.2f %12s\n", teacher.getId(), teacher.getName(), "$", teacher.getBaseSalary(), "$", teacher.calculateSalary(), type);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter any value to return to the main menu : ");
        sc.next();
    }

    public void seeCoursesListMenu() {
        printListOfCourses(this.university.getCourseList(), "University");
        System.out.println("---------------------------------------------------------------");
        System.out.println("do you want to see the details of a class?:");
        System.out.printf("%24s\n%29s\n", "(1) Yes", "(2) No, back");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter the value: ");
        int option = sc.nextInt();
        if (option == 1) {
            coursesListMenuController();
        } else if (option != 2) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("The value entered is not valid");
            System.out.println("---------------------------------------------------------------");
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
            printListOfStudents(course.getStudentList());
            System.out.println("---------------------------------------------------------------");
        } else {
            System.out.println("---------------------------------------------------------------");
            System.out.println("The entered id does not belong to any registered class");
            System.out.println("---------------------------------------------------------------");
        }
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
        printListOfStudents(this.university.getStudentList());
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter the id of the student you want to know\nthe courses he/she is enrolled in : ");
        int idStudent = sc.nextInt();
        Student foundStudent = this.university.getStudentById(idStudent);
        if (foundStudent.getName() != null) {
            List<Course> studentCourses = this.university.getCoursesByStudentId(idStudent);
            printListOfCourses(studentCourses, foundStudent.getName());
        } else {
            System.out.println("---------------------------------------------------------------");
            System.out.println("\nThe entered id does not belong to any registered student");
            System.out.println("---------------------------------------------------------------");
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


    private void seeStudentCreationMenu() {
        cleanScanner();
        System.out.println("===============================================================");
        System.out.printf("%35s \n", "Student Creation Menu");
        System.out.println("===============================================================");
        System.out.println("Do you want to create a new student? :");
        System.out.printf("%24s\n%29s\n", "(1) Yes", "(2) No, back");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter the value: ");
        int option = sc.nextInt();
        if (option == 1) {
            studentCreationController();
        } else if (option != 2) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("The value entered is not valid");
            System.out.println("---------------------------------------------------------------");
            seeMenuToGoBack();
            seeStudentCreationMenu();
        }
    }

    public void studentCreationController() {
        cleanScanner();
        System.out.print("Enter the new student's name : ");
        String newStudentName = sc.nextLine();
        System.out.print("Enter the new student's age : ");
        short newStudentAge = sc.nextShort();
        Student newStudent = new Student(newStudentName, newStudentAge);
        this.university.addStudent(newStudent);
        System.out.println("---------------------------------------------------------------");
        System.out.println("The student was successfully registered at the university");
        System.out.println("---------------------------------------------------------------");
        boolean exit = false;
        while (!exit) {
        System.out.println("Do you want to add the new student to a class?");
            System.out.printf("%24s\n%29s\n", "(1) Yes", "(2) No, back");
            System.out.println("---------------------------------------------------------------");
            System.out.print("Enter the value: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    seeMenuRegisterStudentCourse(newStudent.getId());
                    exit = true;
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("The student was correctly stored with the \ninformation provided so far");
                    System.out.println("---------------------------------------------------------------");

                    seeMenuToGoBack();
                    exit = true;
                    break;
                default:
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("The value entered is not valid");
                    System.out.println("---------------------------------------------------------------");
                    break;
            }
        }
    }

    public void seeMenuRegisterStudentCourse(int studentId) {
        cleanScanner();
        printListOfCourses(this.university.getCourseList(), "University");
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter id of the class you want to add the student to : ");
            int idCourse = sc.nextInt();
            if (this.university.isThereCourseById(idCourse)) {
                this.university.addStudentToCourse(studentId, idCourse);
                System.out.println("---------------------------------------------------------------");
                System.out.println("The student was successfully registered to the class");
            } else {
                System.out.println("---------------------------------------------------------------");
                System.out.println("The entered id does not belong to any class");
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println("Do you want to add the student to another class? :");
            System.out.printf("%24s\n%29s\n", "(1) Yes", "(Other value) No, back");
            System.out.println("---------------------------------------------------------------");
            System.out.print("Enter the value: ");
            String option = sc.next();
            if (!option.equals("1")) {
                exit = true;
            }
        }
    }

    public void seeCourseCreationMenu() {
        cleanScanner();
        System.out.println("===============================================================");
        System.out.printf("%35s \n", "Class Creation Menu");
        System.out.println("===============================================================");
        System.out.println("Do you want to create a new Class? :");
        System.out.printf("%24s\n%29s\n", "(1) Yes", "(2) No, back");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter the value: ");
        int option = sc.nextInt();
        if (option == 1) {
            classCreationController();
        } else if (option != 2) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("The value entered is not valid");
            System.out.println("---------------------------------------------------------------");
            seeCourseCreationMenu();
        }
    }

    public void classCreationController() {
        cleanScanner();
        Course newCourse = new Course();
        System.out.print("Enter a new class name: ");
        String newClassName = sc.nextLine();
        newCourse.setName(newClassName);
        System.out.print("Enter the assigned classroom: ");
        String newClassAssigned = sc.nextLine();
        newCourse.setAssignedClassroom(newClassAssigned);
        System.out.println("Choose one of the following teachers: ");
        System.out.println("===============================================================");
        System.out.printf("%35s \n", "University Teachers");
        System.out.println("===============================================================");
        System.out.printf("%20s %8s %10s\n", "id", "Name", "Type");
        System.out.println("---------------------------------------------------------------");
        List<Teacher> teachers = this.university.getTeacherList();
        for (Teacher teacher : teachers) {
            String type = (teacher.getClass().getSimpleName().equals("FullTimeTeacher")) ? "Full Time" : "Part Time";
            System.out.printf("%20s %8s %10s\n", teacher.getId(), teacher.getName(), type);
        }
        System.out.println("---------------------------------------------------------------");
        boolean exit = false;
        while (!exit) {
            System.out.print("Enter the id of the selected teacher: ");
            int teacherId = sc.nextInt();
            if (this.university.isThereTeacherById(teacherId)) {
                this.university.addCourse(newCourse);
                this.university.setTeacherOfCourse(newCourse.getId(), teacherId);
                exit = true;
            } else {
                System.out.println("---------------------------------------------------------------");
                System.out.println("The entered id does not belong to any teacher");
                System.out.println("---------------------------------------------------------------");
            }
        }
        exit = false;
        while (!exit) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Do you want to add students to new class? :");
            System.out.printf("%24s\n%23s\n", "(1) Yes", "(2) No");
            System.out.println("---------------------------------------------------------------");
            System.out.print("Enter the value: ");
            int option = sc.nextInt();
            if (option == 1) {
                seeAddStudentsToCourseController(newCourse.getId());
            } else if (option == 2) {
                exit = true;
            } else {
                System.out.println("---------------------------------------------------------------");
                System.out.println("The value entered is not valid");
                System.out.println("---------------------------------------------------------------");
            }
        }
        seeCourseCreationMenu();
    }

    public void seeAddStudentsToCourseController(int courseId) {
        printListOfStudents(this.university.getStudentList());
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter the id of the student you want to add to the class :");
        int studentId = sc.nextInt();
        if (this.university.isThereStudentById(studentId)) {
            this.university.addStudentToCourse(studentId, courseId);
            System.out.println("---------------------------------------------------------------");
            System.out.println("Student added successfully");
            System.out.println("---------------------------------------------------------------");
        } else {
            System.out.println("---------------------------------------------------------------");
            System.out.println("The entered id does not belong to any Student");
            System.out.println("---------------------------------------------------------------");
        }
    }

    public void seeMenuToGoBack() {
        cleanScanner();
        System.out.print("Enter any value to go back : ");
        sc.nextLine();
    }

    public void cleanScanner() {
        sc = new Scanner(System.in);
    }
}

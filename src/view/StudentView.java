package view;

import controller.StudentController;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {
    private static int id = 0;
    private static final StudentController studentController = new StudentController();

    public static void createStudent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("name: ");
        String name = sc.nextLine();

        System.out.print("mark: ");
        double mark = sc.nextDouble();
        sc.nextLine();

        if (!name.isEmpty() && mark != 0) {
            id++;
            studentController.addStudent(id, name, mark);
        } else {
            System.out.println("You haven't entered the name or mark or id yet.");
            createStudent();
        }
    }

    public static void updateStudent() {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        String name = "";
        double mark = 0;
        try {
            System.out.print("id: ");
            id = sc.nextInt();
            sc.nextLine();

            System.out.println("data needs to be changed");

            System.out.print("name: ");
            name = sc.nextLine();

            System.out.print("mark: ");
            mark = sc.nextDouble();
            sc.nextLine();
        } catch (Throwable ignored) {
            System.out.println("error Data type");
        }

        if (id != 0) {
            studentController.updateStudent(id, name, mark);
            System.out.println("success!!");
        } else {
            System.out.println("You haven't entered the id yet.");
            updateStudent();
        }
    }

    public static void viewStudent() {
        System.out.println("view information of all students in the class");
        print(studentController.getAllStudent());
    }

    public static void searchNameStudent() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> infoStudents;

        System.out.println("Who are you looking for?");
        String str = sc.nextLine();

        if (str.isEmpty()) {
            infoStudents = studentController.getAllStudent();
        } else {
            infoStudents = studentController.search(str);
        }

        print(infoStudents);
    }

    public static void sortByMarks() {
        ArrayList<String> infoStudents = studentController.sort();

        System.out.println("arrange the student list by marks");

        print(infoStudents);
    }

    private static void print(ArrayList<String> infoStudent) {
        System.out.println("****************************************************");
        for (var member : infoStudent) {
            System.out.println("**" + member);
        }
        System.out.println("****************************************************");
    }

    public static void choice() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;

        while (check) {
            System.out.println("*********************************");
            System.out.println("* (1). Create Student           *");
            System.out.println("* (2). Update Student           *");
            System.out.println("* (3). View All Student         *");
            System.out.println("* (4). Search Name Student      *");
            System.out.println("* (5). Sort by Student's mark   *");
            System.out.println("*********************************");
            System.out.println("What do you want ?");
            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        createStudent();
                        break;
                    case 2:
                        viewStudent();
                        updateStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        searchNameStudent();
                        break;
                    case 5:
                        sortByMarks();
                        break;
                    default:
                        System.out.println("There is no option");
                        choice();
                        break;
                }
            } catch (Throwable ignored) {
                System.out.println("error Data Type");
            }

            checkansware(check);

        }
        sc.close();
    }

    public static void checkansware(boolean check) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to end the program? (yes/no)");
        String choiceEnd = sc.nextLine();

        if (choiceEnd.equals("yes")) {
            check = false;
        } else if (!choiceEnd.equals("no")) {
            System.out.println("the answer is invalid");
            checkansware(check);
        }
    }
}

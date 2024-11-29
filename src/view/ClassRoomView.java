package view;

import com.sun.tools.jconsole.JConsoleContext;
import controller.ClassRoomController;

import java.util.Objects;
import java.util.Scanner;

public class ClassRoomView {
    private static final ClassRoomController classRoomController = new ClassRoomController();

    public static void createClassRoom() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students in your classroom: ");
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (Throwable ignored) {
            System.out.println("The many of students in your classroom is: 0");
        }
        sc.nextLine();

        System.out.print("your name class is: ");
        String name = sc.nextLine();

        if (!Objects.equals(name, "")) {
            if (number != 0) {
                classRoomController.createClassRoom(name, number);
                System.out.println("success!");
            }else{

                System.out.println("class don't have student");
                System.out.println("Do you want to end the program? (yes/no)");
                String choiceEnd = sc.nextLine();

                if (choiceEnd.equals("yes")) {
                    sc.close();
                }
                createClassRoom();
            }
        } else {
            System.out.println("You haven't entered the class name yet.");
            createClassRoom();
        }
    }
}

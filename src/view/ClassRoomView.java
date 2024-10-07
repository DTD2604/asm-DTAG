package view;

import controller.ClassRoomController;

import java.util.Objects;
import java.util.Scanner;

public class ClassRoomView {
    private static final ClassRoomController classRoomController = new ClassRoomController();

    public static void createClassRoom() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students in your classroom: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("your name class is: ");
        String name = sc.nextLine();

        if (!Objects.equals(name, "")) {
            classRoomController.createClassRoom(name, number);
        } else {
            System.out.println("You haven't entered the class name yet.");
            createClassRoom();
        }
    }
}

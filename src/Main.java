import view.ClassRoomView;
import view.StudentView;

public class Main {
    public static void main(String[] args) {
        System.out.println("WelCome to Student Management System!!!");

        ClassRoomView.createClassRoom();

        System.out.println("The features in the system: ");

        StudentView.choice();
    }
}
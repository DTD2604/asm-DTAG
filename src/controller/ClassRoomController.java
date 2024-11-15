package controller;

import model.ClassRoom;
import model.DataStorage;

import java.util.ArrayList;
import java.util.Objects;

public class ClassRoomController {
    private static String Name;

    public void createClassRoom(String name, int number) {
        ClassRoom classRoom = new ClassRoom();
        ArrayList<ClassRoom> newClassRoom = new ArrayList<>();

        classRoom.setName(name);
        classRoom.setNumberStudent(number);

        newClassRoom.add(classRoom);
        DataStorage.getInstance().setDataClassRoom(newClassRoom);
        Name = name;
    }

    public ArrayList<ClassRoom> getAllClass() {
        return DataStorage.getInstance().getDataClassRoom();
    }

    public static ClassRoom getClassRoomByName() {
        ClassRoom classRoom = new ClassRoom();
        for (var room : DataStorage.getInstance().getDataClassRoom()) {
            if (Objects.equals(room.getNameClass(), Name)) {
                classRoom = room;
                break;
            }
        }
        return classRoom;
    }
}

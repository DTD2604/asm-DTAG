package controller;

import model.ClassRoom;

import java.util.ArrayList;
import java.util.Objects;

public class ClassRoomController {
    private static final ClassRoom classRooms = new ClassRoom();
    private static String Name;

    public void createClassRoom(String name, int number) {
        ClassRoom classRoom = new ClassRoom();
        ArrayList<ClassRoom> newClassRoom = new ArrayList<>();

        classRoom.setName(name);
        classRoom.setNumberStudent(number);

        newClassRoom.add(classRoom);
        classRooms.setArrClassRoom(newClassRoom);
        Name = name;
    }

    public ArrayList<ClassRoom> getAllClass() {
        return classRooms.getArrClassRoom();
    }

    public static ClassRoom getClassRoomByName(){
        ClassRoom classRoom = new ClassRoom();
        for(var room : classRooms.getArrClassRoom()){
            if(Objects.equals(room.getNameClass(), Name)){
                classRoom = room;
                break;
            }
        }
        return classRoom;
    }
}

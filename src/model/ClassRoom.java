package model;

import java.util.ArrayList;

public class ClassRoom {
    private String name;
    private int numberStudent;
    private ArrayList<ClassRoom> arrClassRoom = new ArrayList<>();

    public void setName(String name ){
        this.name = name;
    }
    public void setNumberStudent(int numberStudent){
        this.numberStudent = numberStudent;
    }

    public String getNameClass(){
        return name;
    }
    public int getNumberStudent(){
        return numberStudent;
    }

    public ArrayList<ClassRoom> getArrClassRoom() {
        return arrClassRoom;
    }

    public void setArrClassRoom(ArrayList<ClassRoom> arrClassRoom) {
        this.arrClassRoom = arrClassRoom;
    }
}

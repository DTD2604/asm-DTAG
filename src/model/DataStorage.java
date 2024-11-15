package model;

import java.util.ArrayList;

public class DataStorage {
    // Khai báo mảng dữ liệu
    private ArrayList<ClassRoom> arrClassRoom = new ArrayList<>();
    private ArrayList<Student> arrStudent = new ArrayList<>();

    // Tạo instance duy nhất của lớp DataStorage
    private static final DataStorage instance = new DataStorage();

    // Constructor để ngăn tạo thêm instance
    private DataStorage() {
    }

    // Phương thức để lấy instance duy nhất
    public static DataStorage getInstance() {
        return instance;
    }

    // Getter và setter cho mảng dữ liệu

    public void setObjStudent(Student student) {
        arrStudent.add(student);
    }

    public ArrayList<ClassRoom> getDataClassRoom() {
        return arrClassRoom;
    }

    public void setDataClassRoom(ArrayList<ClassRoom> arrClassRoom) {
        this.arrClassRoom = arrClassRoom;
    }

    public ArrayList<Student> getDataStudent() {
        return arrStudent;
    }

    public void setDataStudent(ArrayList<Student> arrStudent) {
        this.arrStudent = arrStudent;
    }
}

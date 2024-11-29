package model;

public class Student {
    private int id;
    private String fullName;
    private ClassRoom classRoom;
    private double marks;

    public int getId() {
        return id;
    }

    public String getName() {
        return fullName;
    }

    public String getClassRoom(){
        return classRoom.getNameClass();
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setClassRoom(ClassRoom classRoom){
        this.classRoom = classRoom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getRank() {
        if (marks >= 9.0) return "Excellent";
        else if (marks >= 7.5) return "Very Good";
        else if (marks >= 6.5) return "Good";
        else if (marks >= 5.0) return "Medium";
        else return "Fail";
    }
}

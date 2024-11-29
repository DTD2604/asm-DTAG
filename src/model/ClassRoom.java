package model;

public class ClassRoom {
    private String name;
    private int numberStudent;

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
}

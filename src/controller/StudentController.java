package controller;

import model.DataStorage;
import model.Student;

import java.util.*;

public class StudentController {

    public void addStudent(int id, String fullName, double marks) {
        Student student = new Student();

        var classRoom = ClassRoomController.getClassRoomByName();
        if (classRoom.getNumberStudent() != (long) DataStorage.getInstance().getDataStudent().size()) {
            try {
                student.setId(id);
                student.setFullName(fullName);
                student.setMarks(marks);
                student.setClassRoom(classRoom);

                DataStorage.getInstance().setObjStudent(student);
                System.out.println("success!!");
            } catch (Throwable ignored) {
                System.out.println("cannot add student in the class");
            }

        } else {
            System.out.println("The number of students in the class " +
                    classRoom.getNameClass() + "is full.");
        }
    }

    public void updateStudent(int id, String fullName, double marks) {
        DataStorage.getInstance().setDataStudent(update(id, fullName, marks));
    }

    public ArrayList<String> getAllStudent() {
        return getStudent(DataStorage.getInstance().getDataStudent());
    }

    public ArrayList<String> sort() {
        int minIndex;
        int total = DataStorage.getInstance().getDataStudent().size();
        ArrayList<Student> newArrStudent = new ArrayList<>(DataStorage.getInstance().getDataStudent());

        for (int i = 0; i < total - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < total; j++) {
                if (newArrStudent.get(j).getMarks() <
                        newArrStudent.get(minIndex).getMarks()) {
                    minIndex = j;
                }
            }

            var temp = newArrStudent.get(minIndex);
            newArrStudent.set(minIndex, newArrStudent.get(i));
            newArrStudent.set(i, temp);
        }

        return getStudent(newArrStudent);
    }

    public ArrayList<String> search(String str) {
        ArrayList<Student> searchName = new ArrayList<>();

        for (var member : DataStorage.getInstance().getDataStudent()) {
            if (member.getName().equals(str)) {
                searchName.add(member);
            }
        }

        return getStudent(searchName);
    }

    private ArrayList<String> getStudent(ArrayList<Student> students) {
        ArrayList<String> allStudent = new ArrayList<>();
        for (Student student1 : students) {
            String member = "ID: " + student1.getId() +
                    ", Name: " + student1.getName() +
                    ", Class: " + student1.getClassRoom() +
                    ", Marks: " + student1.getMarks() +
                    ", Rank: " + student1.getRank();
            allStudent.add(member);
        }
        return allStudent;
    }

    private ArrayList<Student> update(int id, String fullName, double marks) {
        ArrayList<Student> student = DataStorage.getInstance().getDataStudent();
        for (var member : student) {
            if (searchId(id, member)) {
                if (!fullName.isEmpty()) {
                    member.setFullName(fullName);
                }

                if (marks != 0) {
                    member.setMarks(marks);
                }
            }
        }
        return student;
    }

    private boolean searchId(int id, Student student) {
        return student.getId() == id;
    }
}

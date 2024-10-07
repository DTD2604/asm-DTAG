package controller;

import model.Student;

import java.util.*;

public class StudentController {

    public Student addStudent(int id, String fullName, double marks) {
        Student student = new Student();

        var classRoom = ClassRoomController.getClassRoomByName();
        student.setId(id);
        student.setFullName(fullName);
        student.setMarks(marks);
        student.setClassRoom(classRoom);

        return student;
    }

    public ArrayList<Student> updateStudent(int id, String fullName, double marks, Student student) {
        for (var member : student.getArrStudent()) {
            if (searchId(id, member)) {
                if (!fullName.isEmpty()) {
                    member.setFullName(fullName);
                } else {
                    System.out.println("You haven't entered the name yet");
                }

                if (marks != 0) {
                    member.setMarks(marks);
                } else {
                    System.out.println("You haven't entered the mark yet");
                }
            }
        }
        return student.getArrStudent();
    }

    public ArrayList<String> getAllStudent(Student student) {
        return getStudent(student);
    }

    public ArrayList<String> sort(Student student) {
        int minIndex;
        int total = student.getArrStudent().size();
        ArrayList<Student> newArrStudent = new ArrayList<>(student.getArrStudent());
        Student newSort = new Student();

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
        newSort.setArrStudent(newArrStudent);

        return getStudent(newSort);
    }

    public ArrayList<String> search(String str, Student student) {
        ArrayList<Student> searchName = new ArrayList<>();
        Student student1 = new Student();

        for (var member : student.getArrStudent()) {
            if (member.getName().equals(str)) {
                searchName.add(member);
            }
        }
        student1.setArrStudent(searchName);

        return getStudent(student1);
    }

    private ArrayList<String> getStudent(Student student) {
        ArrayList<String> allStudent = new ArrayList<>();
        for (Student student1 : student.getArrStudent()) {
            String member = "ID: " + student1.getId() +
                    ", Name: " + student1.getName() +
                    ", Class: " + student1.getClassRoom() +
                    ", Marks: " + student1.getMarks() +
                    ", Rank: " + student1.getRank();
            allStudent.add(member);
        }
        return allStudent;
    }

    private boolean searchId(int id, Student student) {
        return student.getId() == id;
    }
}

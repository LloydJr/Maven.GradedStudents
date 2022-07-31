package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Classroom {

    Student[] students;
    int maxNumStudents;

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(int maxNumStudents) {
        students = new Student[maxNumStudents];
    }

    public Classroom() {
        this(30);
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        double average = 0.0;
        for (Student student : students) {
            average += student.getAverageExamScore();
        }
        average /= students.length;
        return average;

    }
    public void addStudent(Student student){
        ArrayList<Student> newStudent = new ArrayList<>(Collections.singletonList(student));
        newStudent.add(student);
        students = newStudent.toArray(new Student[0]);
    }
    public void removeStudent(String firstName, String lastName){
        ArrayList<Student> loseStudent = new ArrayList<>(Arrays.asList(students));
        loseStudent.clear();
        students = loseStudent.toArray(new Student[0]);
    }
    public Student[] getStudentsByScore(){
        Comparator<Student> studentComparator = Comparator
                .comparing(Student::getAverageExamScore).reversed().thenComparing(Student::getLastName);
        Student[] listStudents = getStudents();
        Arrays.sort(listStudents, studentComparator);

        return listStudents;
    }
}

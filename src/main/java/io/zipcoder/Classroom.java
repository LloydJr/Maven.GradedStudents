package io.zipcoder;

import java.util.*;

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
    public HashMap getGradeBook(){
        HashMap<Student, Character> studentCharacterHashMap = new HashMap<>();
        Student[] listStudent = getStudentsByScore();
        int count = 1;

        for (Student student : listStudent) {
            double grade = ((double) count) / ((double) maxNumStudents) * ((double) 100);

            if (student.getNumberOfExamsTaken() == 0)
                studentCharacterHashMap.put(student, ' ');
            else if (grade <= 10)
                studentCharacterHashMap.put(student, 'A');
            else if (grade >= 11 && grade <= 29)
                studentCharacterHashMap.put(student, 'B');
            else if (grade >= 30 && grade <= 50)
                studentCharacterHashMap.put(student, 'C');
            else if (grade >= 51 && grade <= 89)
                studentCharacterHashMap.put(student, 'D');
            else
                studentCharacterHashMap.put(student, 'F');

        }
        return studentCharacterHashMap;
    }
}

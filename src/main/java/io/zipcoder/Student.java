package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScore() {
        StringBuilder results = new StringBuilder();
        int examNum = 1;
        for (Double i : examScores) {
            results.append("Exam ").append(examNum++).append(" -> ").append(i).append("\n");
        }
        return results.toString();

    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }
    public void setExamScore(int examNum, double newScore){
        examScores.set(examNum - 1, newScore);
    }
    public double getAverageExamScore(){
        double average = examScores.stream().reduce(Double::sum).get();
        return average / getNumberOfExamsTaken();
    }
    @Override
    public String toString(){
        return String.format("Student name: %s %s \n" + "> Average Score: %f\n" + "> Exam Scores:\n" + "%s",
                firstName, lastName, getAverageExamScore(), getExamScore());
    }
}

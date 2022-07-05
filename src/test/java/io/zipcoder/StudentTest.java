package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void testGetExamScores(){
        //Given
        String firstName = "John";
        String lastName = "Doe";
        Double[] testScores = {100.0, 95.0, 90.0, 85.0};
        Student student = new Student(firstName, lastName, testScores);
        //When
        String results = String.valueOf(student.getExamScore());
        //Then
         System.out.println(results);
        Assert.assertEquals(results, results);
        //Exam 1 -> 100.0
        //Exam 2 -> 95.0
        //Exam 3 -> 90.0
        //Exam 4 -> 85.0
    }
    @Test
        public void testAddExamScore(){
        //Given
        String firstName = "John";
        String lastName = "Doe";
        Double[] testScores = {};
        Student student = new Student(firstName, lastName, testScores);
        //When
        student.addExamScore(100.0);
        String results = String.valueOf(student.getExamScore());
        //Then
        System.out.println(results);
        Assert.assertEquals(results, results);
        //Exam 1 -> 100.0
    }
    @Test
        public void testSetExamScore() {
        //Given
        String firstName = "John";
        String lastName = "Doe";
        Double[] testScores = {100.0};
        Student student = new Student(firstName, lastName, testScores);
        //When
        student.setExamScore(1, 150.0);
        String results = String.valueOf(student.getExamScore());
        //Then
        System.out.println(results);
        Assert.assertEquals(results, results);
        //Exam 1 -> 150.0
    }
    @Test
        public void testGetAverageExamScore(){
        //Given
        String firstName = "John";
        String lastName = "Doe";
        Double[] testScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, testScores);
        //When
        Double results = student.getAverageExamScore();
        Double expected = 125.0;
        //Then
//        System.out.println(results);
        Assert.assertEquals(expected, results);
        //Exam 1 -> 125.0
    }
    @Test
        public void testToString(){
        //Given
        String firstName = "John";
        String lastName = "Doe";
        Double[] testScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, testScores);
        //When
        String results = student.toString();
        //Then
        System.out.println(results);
        Assert.assertEquals(results, results);
        //Exam 1 -> 100.0, Exam 2 -> 95.0, Exam 3 -> 90.0, Exam 4 -> 85.0}
    }
}
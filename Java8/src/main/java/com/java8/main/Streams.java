package com.java8.main;

import com.java8.pojo.Student;
import com.java8.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String args[]){
        List<Student> studentList = Utils.getStudentList();

        //Getting map of student name and marks whose marks greater than 80
        Map<String,Integer> studentMarksMap = studentList.stream().filter(student -> student.getMarks()>80).collect(Collectors.toMap(Student::getName,Student::getMarks));
        System.out.println(studentMarksMap);

        //MAP - Getting uppercase studentname as list
        List<String>students = studentList.stream().map(Student::getName).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(students);

        //Reduce - reduce content of a stream to a single value
        int studentMarksSum =  studentList.stream().map(Student::getMarks).reduce(0,(mark1,mark2)-> mark1+mark2);
        System.out.println(studentMarksSum);

        //FlatMap - converts a stream where each element in stream represent multiple elements
        List<List<String>>products = new ArrayList<>();
        List<String>product1= Arrays.asList("mobile","cover","sim");
        List<String>product2= Arrays.asList("laptop","computer","cpu");
        List<String>product3= Arrays.asList("notebook","pen","pencil");
        products.add(product1);
        products.add(product2);
        products.add(product3);
        List<String>allProductList = products.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(allProductList);





    }

}

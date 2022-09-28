package com.java8.main;

import com.java8.pojo.Student;
import com.java8.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PreDefinedFuntionalInterface {

    public static void main(String args[]){
        List<Student> studentList = Utils.getStudentList();

        //Predicate -> getting list of student whose marks greater than 80
        System.out.println("*********** Predicate - Getting list of student whose marks greater than 80 *********");
        Predicate<Student>criteriaMarks = student -> student.getMarks()>80;
        List<Student> filteredStudentList= studentList.stream().filter(criteriaMarks).collect(Collectors.toList());
        System.out.println(filteredStudentList);

        //Consumer - getting all students name whose marks greater than 80
        System.out.println("******* Consumer - Getting all students name whose marks greater than 80 *********");
        Consumer<Student>consumer = student -> System.out.println(student.getName());
        studentList.stream().filter(criteriaMarks).forEach(consumer);

        //consumer chaining - each student name followed by marks
        System.out.println("******* Consumer chaining *********");
        Consumer<Student>consumer1 = student -> System.out.print(student.getName() +" ");
        Consumer<Student>consumer2 = student -> System.out.println(student.getMarks());
        studentList.stream().forEach(consumer1.andThen(consumer2));

        //function - get marks of a particular student
        System.out.println("******* function - Getting marks of s1 student *********");
        Function<Student,Integer> function = (student -> student.getMarks());
        System.out.println(function.apply(studentList.get(0)));

        //Supplier - get default object using supplier
        System.out.println("******* Supplier - Get default student object  *********");
        Supplier<Student> supplier = () -> Student.builder().name("default Std").marks(0).grade('D').build();
        System.out.println(supplier.get());



    }
}

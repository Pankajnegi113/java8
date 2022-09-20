package com.java8.main;

import com.java8.pojo.Student;
import com.java8.util.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiPredefinedFunctionalInterface {

    public static void main(String str[]){
        BiPredicate<Integer,Integer>biPredicate = (a,b)->(a+b)%2==0;
        System.out.println("Sum of given numbers is even or not"+ biPredicate.test(17,17));

        BiConsumer<String,String>biConsumer = (str1,str2)-> System.out.println(str1+str2);
        biConsumer.accept("Hello","World!");

        List<Student> studentList = Utils.getStudentList();
        Predicate<Student>criteriaMarks = student -> student.getMarks()>80;
        BiFunction<List<Student>,Predicate<Student>,Map<String,Integer>> biFunction = (stdList,predicate)->{
            Map<String,Integer> map = new HashMap<>();
            stdList.forEach(std->{
                if(predicate.test(std)){
                    map.put(std.getName(),std.getMarks());
                }
            });
           return map;
        };

        System.out.println("Map of student and marks "+biFunction.apply(studentList,criteriaMarks));
    }
}

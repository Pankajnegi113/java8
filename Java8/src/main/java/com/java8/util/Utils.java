package com.java8.util;

import com.java8.pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Student> getStudentList(){
        List<Student> studentList = new ArrayList<>();
        Student s1 = Student.builder().name("std1").grade('A').marks(95).build();
        Student s2 = Student.builder().name("std2").grade('B').marks(85).build();
        Student s3 = Student.builder().name("std3").grade('C').marks(78).build();
        Student s4 = Student.builder().name("std4").grade('C').marks(72).build();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        return studentList;
    }
}

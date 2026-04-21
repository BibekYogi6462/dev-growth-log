package com.bibek.springboot_rest_api.controller;


import com.bibek.springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1, "Bibek", "Yogi");
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Bibek", "Yogi"));
        students.add(new Student(2,"Bibek", "Yogi"));
        return students;

    }


    //Springboot restapi with pathvariable

    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int id){
        return new Student(id, "Bibek", "Yogi");
    }

    @GetMapping("/studentss/{id}/{firstName}/{lastName}")
    public Student studentsPath(@PathVariable("id") int id, @PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        return new Student(id,firstName,lastName);
    }

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName
                                          ){
        return new Student(id, firstName, lastName);
    }


}

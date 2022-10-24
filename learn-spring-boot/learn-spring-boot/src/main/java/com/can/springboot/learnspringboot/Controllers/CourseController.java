package com.can.springboot.learnspringboot.Controllers;

//Courses have
// id, name, author

import com.can.springboot.learnspringboot.Classes.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses()
    {
        return Arrays.asList(
                new Course(1,"Learn AWS" , "today"),
                new Course(2,"Learn DevOps" , "today"),
                new Course(2,"Learn DevOps" , "tomorrow"),
                new Course(2,"Learn DevOps" , "yesterday")
        );
    }



}

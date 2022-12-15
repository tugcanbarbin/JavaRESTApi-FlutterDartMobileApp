package com.example.springboot.learnjpaandhibernate.jdbc;

import com.example.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner  implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args)throws  Exception
    {
        repository.insert(new Course(1,"Learn jdbc run function", "me"));
        repository.insert(new Course(2,"Learn aws run function", "me"));
        repository.insert(new Course(3,"Learn hibernate run function", "me"));
        repository.delete("1");
    }
}

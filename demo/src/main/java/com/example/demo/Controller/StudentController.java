package com.example.demo.Controller;

import Repositories.StudentRepository;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Controller
@EnableAutoConfiguration
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(String name, Set<Course> subjects){
        Student student = new Student();
        student.setStudentName(name);
        student.setAssociatedCourses(subjects);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        Student s = studentRepository.findById(studentId).get();
        studentRepository.delete(s);
    }

    public List<String> sort(String CourseName) {
        Iterable<Student> itr = studentRepository.findAll();
        List<String> ans = new ArrayList<>();
        while(itr.iterator().hasNext()){
            Student s = itr.iterator().next();
            if(s.getAssociatedCourses().contains(CourseName)) {
                ans.add(s.getStudentName());
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

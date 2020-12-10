package com.example.demo.pojo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long CourseID;
    private String CourseName;

    @ManyToMany(mappedBy = "associatedCourses")
    Set<Student> students;

    public Course() {
    }

    public Course(Long courseID, String courseName) {
        CourseID = courseID;
        CourseName = courseName;
    }

    public Long getCourseID() {
        return CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseID(Long courseID) {
        CourseID = courseID;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
}

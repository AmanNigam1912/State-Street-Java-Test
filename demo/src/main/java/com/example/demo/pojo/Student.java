package com.example.demo.pojo;

import javax.persistence.*;
//import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long StudentID;
    private String StudentName;

    @ManyToMany
    @JoinTable(
        name = "course_associate",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    Set<Course> associatedCourses;

    public Student() {

    }

    public Set<Course> getAssociatedCourses() {
        return associatedCourses;
    }

    public void setAssociatedCourses(Set<Course> associatedCourses) {
        this.associatedCourses = associatedCourses;
    }

    public Student(Long studentID, String studentName) {
        StudentID = studentID;
        StudentName = studentName;
    }

    public Long getStudentID() {
        return StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentID(Long studentID) {
        StudentID = studentID;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }
}

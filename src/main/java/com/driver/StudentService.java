package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){

        studentRepository.addStudent(student);
        return;
    }

    public void addTeacher(Teacher teacher){

        studentRepository.addTeacher(teacher);
        return;
    }

    public Student getStudent(String name){

        return studentRepository.getStudent(name).get();
    }

    public Teacher getTeacher(String name){

        return studentRepository.getTeacher(name).get();
    }


    public void addStudentTeacherPair(String student, String teacher) {

        studentRepository.addStudentTeacherPair(student,teacher);
        return;
    }

    public List<String> getStudentsByTeacherName(String teacher) {

        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {

        return studentRepository.getAllStudents();
    }

    public void deleteAllTeachers() {

        studentRepository.deleteAllTeachers();
        return;
    }

    public void deleteTeacherByName(String teacher) {

        studentRepository.deleteTeacherByName(teacher);
        return;
    }
}
package com.driver;


import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

@Repository
public class StudentRepository {

    Map<String,Student> studentMap;
    Map<String,Teacher> teacherMap;
    Map<String, List<String>> teacherToStudentMap;

    public StudentRepository(){
        studentMap = new HashMap<>();
        teacherMap = new HashMap<>();
        teacherToStudentMap = new HashMap<>();
    }


    public void addStudent(Student student){

        studentMap.put(student.getName(),student);
        return;
    }

    public void addTeacher(Teacher teacher){

        teacherMap.put(teacher.getName(),teacher);
        return;
    }

    public Optional<Student> getStudent(String name){

        if(studentMap.containsKey(name)) return Optional.of(studentMap.get(name));

        return Optional.empty();
    }

    public Optional<Teacher> getTeacher(String name){

        if(teacherMap.containsKey(name)) return Optional.of(teacherMap.get(name));

        return Optional.empty();

    }

    public void addStudentTeacherPair(String student, String teacher) {

        List<String> students = new ArrayList<>();
        if(teacherToStudentMap.containsKey(teacher))
            students = teacherToStudentMap.get(teacher);


//        if(students.contains(student)) return;
        students.add(student);
        teacherToStudentMap.put(teacher,students);
        return;
    }

    public List<String> getStudentsByTeacherName(String teacher) {

        if(!teacherToStudentMap.containsKey(teacher)) return new ArrayList<>();

        return teacherToStudentMap.get(teacher);
    }

    public List<String> getAllStudents() {

        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteAllTeachers() {

        teacherMap = new HashMap<>();
        for (String teacher : teacherToStudentMap.keySet()){
            List<String> students = teacherToStudentMap.get(teacher);
            for (String student : students){
                if (studentMap.containsKey(student))
                    studentMap.remove(student);
            }
        }
        teacherToStudentMap = new HashMap<>();
        return;
    }

    public void deleteTeacherByName(String teacher) {

        List<String> students = teacherToStudentMap.get(teacher);
        teacherToStudentMap.remove(teacher);
        teacherMap.remove(teacher);
        for (String student : students){
            if (studentMap.containsKey(student))
                studentMap.remove(student);
        }
        return;
    }
}
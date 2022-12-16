package com.example.class3demo.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model instance(){
        return _instance;
    }

    private Model(){
        Student st = new Student("test","1","",false);
        addStudent(st);
    }

    List<Student> data = new LinkedList<>();

    public List<Student> getAllStudents(){
        return data;
    }

    public Student getStudent(int pos){
        return data.get(pos);
    }

    public void addStudent(Student st){
        data.add(st);
    }


}

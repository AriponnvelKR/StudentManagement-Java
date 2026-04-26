package com.example;

public class Student {
    int id;
    String name;
    double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Grade: " + grade);
    }
}
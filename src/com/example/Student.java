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
        System.out.println("-----------------------------");
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Grade : " + grade + "%");
        System.out.println("Rank  : " + getRank());
        System.out.println("-----------------------------");
    }

    public String getRank() {
        if (grade >= 90) return "A+";
        else if (grade >= 80) return "A";
        else if (grade >= 70) return "B";
        else if (grade >= 60) return "C";
        else if (grade >= 50) return "D";
        else return "F";
    }
}
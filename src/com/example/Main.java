package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Update Name");
            System.out.println("6. Student Count");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();

                // Check duplicate ID
                boolean exists = false;
                for (Student s : students) {
                    if (s.id == id) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("ID already exists!");
                } else {
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade = sc.nextDouble();
                    students.add(new Student(id, name, grade));
                    System.out.println("Student added!");
                }

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No students found!");
                } else {
                    for (Student s : students) {
                        s.display();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                boolean removed = students.removeIf(s -> s.id == id);
                if (removed) {
                    System.out.println("Student deleted!");
                } else {
                    System.out.println("Student not found!");
                }

            } else if (choice == 4) {
                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Student s : students) {
                    if (s.id == id) {
                        s.display();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found!");
                }

            } else if (choice == 5) {
                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                boolean found = false;
                for (Student s : students) {
                    if (s.id == id) {
                        System.out.print("Enter new name: ");
                        s.name = sc.nextLine();
                        System.out.println("Name updated!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found!");
                }

            } else if (choice == 6) {
                System.out.println("Total students: " + students.size());

            } else {
                break;
            }
        }

        sc.close();
    }
}
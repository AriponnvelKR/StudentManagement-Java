package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=============================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("=============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Update Name");
            System.out.println("6. Student Count");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by Grade");
            System.out.println("9. Exit");
            System.out.println("=============================");
            System.out.print("Enter your choice: ");

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
                    System.out.println("❌ ID already exists!");
                } else {
                    sc.nextLine();

                    // Validate name
                    String name = "";
                    while (name.trim().isEmpty()) {
                        System.out.print("Enter Name: ");
                        name = sc.nextLine();
                        if (name.trim().isEmpty()) {
                            System.out.println("❌ Name cannot be empty!");
                        }
                    }

                    // Validate grade
                    double grade = -1;
                    while (grade < 0 || grade > 100) {
                        System.out.print("Enter Grade (0-100): ");
                        grade = sc.nextDouble();
                        if (grade < 0 || grade > 100) {
                            System.out.println("❌ Grade must be between 0 and 100!");
                        }
                    }

                    students.add(new Student(id, name, grade));
                    System.out.println("✅ Student added successfully!");
                }

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("❌ No students found!");
                } else {
                    System.out.println("\n📋 All Students:");
                    for (Student s : students) {
                        s.display();
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                boolean removed = students.removeIf(s -> s.id == id);
                if (removed) {
                    System.out.println("✅ Student deleted successfully!");
                } else {
                    System.out.println("❌ Student not found!");
                }

            } else if (choice == 4) {
                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();
                boolean found = false;
                for (Student s : students) {
                    if (s.id == id) {
                        System.out.println("\n🔍 Student Found:");
                        s.display();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("❌ Student not found!");
                }

            } else if (choice == 5) {
                System.out.print("Enter ID to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                boolean found = false;
                for (Student s : students) {
                    if (s.id == id) {
                        String newName = "";
                        while (newName.trim().isEmpty()) {
                            System.out.print("Enter new name: ");
                            newName = sc.nextLine();
                            if (newName.trim().isEmpty()) {
                                System.out.println("❌ Name cannot be empty!");
                            }
                        }
                        s.name = newName;
                        System.out.println("✅ Name updated successfully!");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("❌ Student not found!");
                }

            } else if (choice == 6) {
                System.out.println("📊 Total students: " + students.size());

            } else if (choice == 7) {
                if (students.isEmpty()) {
                    System.out.println("❌ No students to sort!");
                } else {
                    students.sort(Comparator.comparing(s -> s.name));
                    System.out.println("✅ Sorted by Name!");
                    for (Student s : students) {
                        s.display();
                    }
                }

            } else if (choice == 8) {
                if (students.isEmpty()) {
                    System.out.println("❌ No students to sort!");
                } else {
                    students.sort((a, b) -> Double.compare(b.grade, a.grade));
                    System.out.println("✅ Sorted by Grade (highest first)!");
                    for (Student s : students) {
                        s.display();
                    }
                }

            } else if (choice == 9) {
                System.out.println("👋 Goodbye!");
                break;

            } else {
                System.out.println("❌ Invalid choice! Please enter 1-9.");
            }
        }

        sc.close();
    }
}
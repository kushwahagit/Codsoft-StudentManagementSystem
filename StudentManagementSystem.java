import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Create a copy to prevent modification
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice=0;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear input buffer
                continue;
            }

            switch (choice) {
                case 1:
                    // Add student logic with input validation
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    Student student = new Student(rollNumber, name, grade);
                    system.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    // Remove student logic with error handling
                    System.out.print("Enter roll number of student to remove: ");
                    int rollNumberToRemove = scanner.nextInt();
                    system.removeStudent(rollNumberToRemove);
                    System.out.println("Student removed successfully.");
                    break;
                case 3:
                    // Search student logic with error handling
                    System.out.print("Enter roll number of student to search: ");
                    int rollNumberToSearch = scanner.nextInt();
                    Student foundStudent = system.searchStudent(rollNumberToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        System.out.println("Roll Number: " + foundStudent.getRollNumber());
                        System.out.println("Name: " + foundStudent.getName());
                        System.out.println("Grade: " + foundStudent.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    // Display all students logic
                    List<Student> allStudents = system.getAllStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("All Students:");
                        for (Student student1 : allStudents) {
                            System.out.println("Roll Number: " + student1.getRollNumber() +
                                    ", Name: " + student1.getName() + ", Grade: " + student1.getGrade());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice!= 5);

        scanner.close();
    }

    static class Student {
        private int rollNumber;
        private String name;
        private String grade;

        public Student(int rollNumber, String name, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.grade = grade;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public String getName() {
            return name;
        }

        public String getGrade() {
            return grade;
        }
    }
}

package main;
import dao.StudentDAO;
import model.Student;
import java.util.List;
import java.util.Scanner;
public class Main {
static StudentDAO dao = new StudentDAO();
static Scanner sc = new Scanner(System.in);
public static void main(String[] args) {
System.out.println("=== Student Management System ===");
while (true) {
System.out.println("\n1. Add Student");
System.out.println("2. View All Students");
System.out.println("3. Search Student by ID");
System.out.println("4. Update Student");
System.out.println("5. Delete Student");
System.out.println("6. Exit");
System.out.print("Choose option: ");
int ch = sc.nextInt();
switch (ch) {
case 1 -> addStudent();
case 2 -> viewAll();
case 3 -> searchStudent();
case 4 -> updateStudent();
case 5 -> deleteStudent();
case 6 -> { System.out.println("Goodbye!"); return; }
default -> System.out.println("Invalid option!");
}
}
}
static void addStudent() {
sc.nextLine();
System.out.print("Name: "); String name = sc.nextLine();
System.out.print("Email: "); String email = sc.nextLine();
System.out.print("Phone: "); String phone = sc.nextLine();
System.out.print("Course: "); String course = sc.nextLine();
System.out.print("Marks: "); double marks = sc.nextDouble();
Student s = new Student(name, email, phone, course, marks);
System.out.println(dao.addStudent(s) ? "Added successfully!" : "Failed!");
}
static void viewAll() {
List<Student> list = dao.getAllStudents();
if (list.isEmpty()) { System.out.println("No records found."); return; }
System.out.println("\n--- All Students ---");
list.forEach(System.out::println);
}
static void searchStudent() {
System.out.print("Enter Student ID: ");
int id = sc.nextInt();
Student s = dao.getStudentById(id);
System.out.println(s != null ? s : "Student not found.");
}
static void updateStudent() {
System.out.print("Enter Student ID to update: ");
int id = sc.nextInt();
Student s = dao.getStudentById(id);
if (s == null) { System.out.println("Not found."); return; }
sc.nextLine();
System.out.print("New Name: "); s.setName(sc.nextLine());
System.out.print("New Email: "); s.setEmail(sc.nextLine());
System.out.print("New Course: "); s.setCourse(sc.nextLine());
System.out.print("New Marks: "); s.setMarks(sc.nextDouble());
System.out.println(dao.updateStudent(s) ? "Updated!" : "Failed!");
  }
static void deleteStudent() {
System.out.print("Enter Student ID to delete: ");
int id = sc.nextInt();
System.out.println(dao.deleteStudent(id) ? "Deleted!" : "Not found.");
}
}

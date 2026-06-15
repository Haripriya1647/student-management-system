package model;
public class Student {
// Fields (Encapsulation - private variables)
private int id;
private String name;
private String email;
private String phone;
private String course;
private double marks;
// Default Constructor
public Student() {}
// Parameterized Constructor
public Student(String name, String email, String phone,
String course, double marks) {
this.name = name;
this.email = email;
this.phone = phone;
this.course = course;
this.marks = marks;
}
// Getters and Setters
public int getId() {
  return id; 
}
public void setId(int id) { 
  this.id = id; 
}
public String getName() { 
  return name; 
}
public void setName(String n) {
  this.name = n; 
}
public String getEmail() { 
  return email; 
}
public void setEmail(String e) {
  this.email = e; 
}
public String getPhone() { 
  return phone; 
}
public void setPhone(String p) { 
  this.phone = p; 
}
public String getCourse() {
  return course; 
}
public void setCourse(String c) { 
  this.course = c; 
}
public double getMarks() {
  return marks; 
}
public void setMarks(double m) {
  this.marks = m; 
}
@Override
public String toString() {
return String.format(
"ID: %d | Name: %s | Email: %s | Course: %s | Marks: %.2f",
id, name, email, course, marks);
}
}

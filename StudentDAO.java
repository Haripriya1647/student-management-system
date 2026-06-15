package dao;
import model.Student;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {
// ===== CREATE - Student add cheyyadam =====
public boolean addStudent(Student s) {
String sql = "INSERT INTO students(name,email,phone,course,marks) VALUES(?,?,?,?,?)";
try (Connection conn = DBConnection.getConnection();
PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, s.getName());
ps.setString(2, s.getEmail());
ps.setString(3, s.getPhone());
ps.setString(4, s.getCourse());
ps.setDouble(5, s.getMarks());
return ps.executeUpdate() > 0;
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
return false;
}
}
// ===== READ ALL - All students fetch =====
public List<Student> getAllStudents() {
List<Student> list = new ArrayList<>();
String sql = "SELECT * FROM students ORDER BY id";
try (Connection conn = DBConnection.getConnection();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql)) {
while (rs.next()) {
Student s = new Student();
s.setId(rs.getInt("id"));
s.setName(rs.getString("name"));
s.setEmail(rs.getString("email"));
s.setPhone(rs.getString("phone"));
s.setCourse(rs.getString("course"));
s.setMarks(rs.getDouble("marks"));
list.add(s);
}
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
}
return list;
}
// ===== READ ONE - ID tho search =====
public Student getStudentById(int id) {
String sql = "SELECT * FROM students WHERE id = ?";
try (Connection conn = DBConnection.getConnection();
PreparedStatement ps = conn.prepareStatement(sql)) {
  ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
Student s = new Student();
s.setId(rs.getInt("id"));
s.setName(rs.getString("name"));
s.setEmail(rs.getString("email"));
s.setPhone(rs.getString("phone"));
s.setCourse(rs.getString("course"));
s.setMarks(rs.getDouble("marks"));
return s;
}
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
}
return null;
}
// ===== UPDATE - Student update cheyyadam =====
public boolean updateStudent(Student s) {
String sql = "UPDATE students SET name=?,email=?,phone=?,course=?,marks=? WHERE id=?";
try (Connection conn = DBConnection.getConnection();
PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, s.getName());
ps.setString(2, s.getEmail());
ps.setString(3, s.getPhone());
ps.setString(4, s.getCourse());
ps.setDouble(5, s.getMarks());
ps.setInt(6, s.getId());
return ps.executeUpdate() > 0;
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
return false;
}
}
// ===== DELETE - Student delete cheyyadam =====
public boolean deleteStudent(int id) {
String sql = "DELETE FROM students WHERE id = ?";
try (Connection conn = DBConnection.getConnection();
PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, id);
return ps.executeUpdate() > 0;
} catch (SQLException e) {
System.out.println("Error: " + e.getMessage());
return false;
}
}
}

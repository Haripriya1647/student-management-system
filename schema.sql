-- Database create cheyyadam
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;
-- Students table create cheyyadam
CREATE TABLE students (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
phone VARCHAR(15),
course VARCHAR(50),
marks DOUBLE DEFAULT 0.0,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- Sample data insert cheyyadam
INSERT INTO students (name, email, phone, course, marks) VALUES
('Reshma', 'reshma@gmail.com', '9876543210', 'B.Tech IT', 87.5),
('Haripriya ', 'priya@gmail.com', '9988776655', 'B.Tech CSE', 91.0),
('Teja', 'teja@gmail.com', '9123456789', 'BCA', 78.3);

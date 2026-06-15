// Mock data (Java backend connect chesaka real API calls vastaayi)
let students = [
{ id:1, name:"Ravi Kumar", email:"ravi@gmail.com",
phone:"9876543210", course:"B.Tech IT", marks:87.5 },
{ id:2, name:"Priya Reddy", email:"priya@gmail.com",
phone:"9988776655", course:"B.Tech CSE", marks:91.0 },
{ id:3, name:"Sai Teja", email:"sai@gmail.com",
phone:"9123456789", course:"BCA", marks:78.3 },
];
// Page load ayinapudu display cheyyadam
window.onload = () => displayStudents(students);
function displayStudents(data) {
const tbody = document.getElementById("tableBody");
if (data.length === 0) {
tbody.innerHTML = '<tr><td colspan="6" style="text-align:center">No students found</td></tr>';
return;
}
tbody.innerHTML = data.map(s => `
<tr>
<td>${s.id}</td><td>${s.name}</td><td>${s.email}</td>
<td>${s.course}</td><td>${s.marks}%</td>
<td>
<button class="btn btn-edit" onclick="editStudent(${s.id})">Edit</button>
<button class="btn btn-danger" onclick="deleteStudent(${s.id})">Delete</button>
</td>
</tr>`).join("");
}
// Real-time search
function searchStudents() {
const q = document.getElementById("searchInput").value.toLowerCase();
displayStudents(students.filter(s =>
s.name.toLowerCase().includes(q) || s.course.toLowerCase().includes(q)
));
}
// Delete student
function deleteStudent(id) {
if (confirm("Are you sure?")) {
students = students.filter(s => s.id !== id);
displayStudents(students);
}
}
// Edit (real app lo edit form page ki redirect avutundi)
function editStudent(id) {
const s = students.find(s => s.id === id);
alert("Editing: " + s.name + "\nReal app lo edit form open avutundi.");
}

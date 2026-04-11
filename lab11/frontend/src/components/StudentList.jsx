import { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ onEdit }) {
  const [students, setStudents] = useState([]);

  const fetchData = () => {
    axios.get("http://localhost:8080/students")
      .then(res => setStudents(res.data));
  };

  useEffect(() => {
    fetchData();
  }, []);

  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8080/students/${id}`)
      .then(() => fetchData());
  };

  return (
    <div>
      <h2>Student List</h2>

      {students.map(s => (
        <div key={s.id}>
          <p>{s.name} | {s.email} | {s.course}</p>

          <button onClick={() => onEdit(s)}>Edit</button>
          <button onClick={() => deleteStudent(s.id)}>Delete</button>

          <hr />
        </div>
      ))}
    </div>
  );
}

export default StudentList;
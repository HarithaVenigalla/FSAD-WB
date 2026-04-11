import { useState, useEffect } from "react";
import axios from "axios";

function AddStudent({ editData, refresh }) {
  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  useEffect(() => {
    if (editData) {
      setStudent(editData);
    }
  }, [editData]);

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = () => {

    if (student.id) {
      // UPDATE
      axios.put(`http://localhost:8080/students/${student.id}`, student)
        .then(() => {
          alert("Updated Successfully");
          refresh();
        });
    } else {
      // ADD
      axios.post("http://localhost:8080/students", student)
        .then(() => {
          alert("Added Successfully");
          refresh();
        });
    }

    setStudent({ name: "", email: "", course: "" });
  };

  return (
    <div>
      <h2>{student.id ? "Update Student" : "Add Student"}</h2>

      <input name="name" value={student.name} onChange={handleChange} placeholder="Name" />
      <input name="email" value={student.email} onChange={handleChange} placeholder="Email" />
      <input name="course" value={student.course} onChange={handleChange} placeholder="Course" />

      <button onClick={handleSubmit}>
        {student.id ? "Update" : "Add"}
      </button>
    </div>
  );
}

export default AddStudent;
import { useState } from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";

function App() {
  const [editData, setEditData] = useState(null);

  const refresh = () => {
    window.location.reload(); // simple refresh
  };

  return (
    <div>
      <h1>Student Management System</h1>

      <AddStudent editData={editData} refresh={refresh} />
      <StudentList onEdit={setEditData} />
    </div>
  );
}

export default App;
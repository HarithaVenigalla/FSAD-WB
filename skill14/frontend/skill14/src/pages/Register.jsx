import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { registerUser } from "../api";

export default function Register() {
  const [user, setUser] = useState({
    username: "",
    password: "",
    email: ""
  });

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const res = await registerUser(user);
    console.log("REGISTER RESPONSE:", res); 
    if (res && res.id) {
      alert("Registered Successfully");
      navigate("/"); 
    } else {
      alert("Registration failed");
    }
  };

  return (
    <div>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <input placeholder="Username"
          onChange={(e) => setUser({ ...user, username: e.target.value })} />

        <input type="password" placeholder="Password"
          onChange={(e) => setUser({ ...user, password: e.target.value })} />

        <input placeholder="Email"
          onChange={(e) => setUser({ ...user, email: e.target.value })} />

        <button type="submit">Register</button>
      </form>
    </div>
  );
}
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getUserProfile } from "../api";

export default function Profile() {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();
  const userId = localStorage.getItem("userId");

  useEffect(() => {
    if (!userId) { navigate("/login"); return; }
    getUserProfile(userId).then(setUser);
  }, [userId]);

  if (!user) return <p>Loading...</p>;

  return (
    <div className="profile-container">
      <h2>Profile</h2>
      <p>Username: {user.username}</p>
      <p>Email: {user.email}</p>
      <button onClick={() => navigate("/home")}>Home</button>
      <button onClick={() => { localStorage.removeItem("userId"); navigate("/login"); }}>Logout</button>
    </div>
  );
}
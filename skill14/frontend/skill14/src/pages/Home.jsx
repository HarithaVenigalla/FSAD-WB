import { useNavigate } from "react-router-dom";

export default function Home() {
  const navigate = useNavigate();
  const userId = localStorage.getItem("userId");

  if (!userId) {
    navigate("/login");
    return null;
  }

  const handleLogout = () => {
    localStorage.removeItem("userId");
    navigate("/login");
  };

  return (
    <div className="home-container">
      <h2>Home</h2>
      <p>Welcome User {userId}</p>
      <button onClick={() => navigate("/profile")}>Profile</button>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
}
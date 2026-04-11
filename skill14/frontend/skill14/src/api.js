// src/api.js

const API_URL = import.meta.env.VITE_API_URL;

// 🔥 Debug (remove later if needed)
console.log("ENV VALUE:", API_URL);

// REGISTER
export async function registerUser(user) {
  try {
    const res = await fetch(`${API_URL}/register`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(user),
    });

    const data = await res.json();
    return data;

  } catch (error) {
    console.error("Register Error:", error);
    return null;
  }
}

// LOGIN
export async function loginUser(user) {
  try {
    console.log("Calling API:", `${API_URL}/login`);

    const res = await fetch(`${API_URL}/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(user),
    });

    console.log("Status:", res.status);

    // 🔥 Safe response handling
    const text = await res.text();
    console.log("Raw response:", text);

    if (!text) return null;

    const data = JSON.parse(text);

    // ❌ If backend sends error
    if (res.status !== 200) {
      console.log("Login failed:", data);
      return null;
    }

    return data;

  } catch (error) {
    console.error("Login Error:", error);
    return null;
  }
}

// GET PROFILE
export async function getUserProfile(id) {
  try {
    const res = await fetch(`${API_URL}/profile/${id}`);

    const text = await res.text();

    if (!text) return null;

    return JSON.parse(text);

  } catch (error) {
    console.error("Profile Error:", error);
    return null;
  }
}
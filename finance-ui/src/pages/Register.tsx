import { useState } from "react";
import AuthLayout from "../components/AuthLayout";

const Register = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("USER"); // default

  const handleRegister = (e: React.FormEvent) => {
    e.preventDefault();

    const data = {
      name,
      email,
      password,
      role,
    };

    console.log(data); // later send to backend
  };

  return (
    <AuthLayout>
      <form
        onSubmit={handleRegister}
        className="bg-white p-8 rounded-xl shadow-md w-80"
      >
        <h2 className="text-2xl font-bold mb-6 text-center">Register</h2>

        <input
          type="text"
          placeholder="Name"
          className="w-full mb-4 p-3 border rounded-lg"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />

        <input
          type="email"
          placeholder="Email"
          className="w-full mb-4 p-3 border rounded-lg"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <input
          type="password"
          placeholder="Password"
          className="w-full mb-4 p-3 border rounded-lg"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        {/* 🔥 ROLE DROPDOWN */}
        <select
          className="w-full mb-4 p-3 border rounded-lg"
          value={role}
          onChange={(e) => setRole(e.target.value)}
        >
          <option value="USER">User</option>
          <option value="ADMIN">Admin</option>
        </select>

        <button className="w-full bg-blue-600 text-white py-3 rounded-lg hover:bg-blue-700">
          Register
        </button>

        <p className="text-sm text-center mt-4">
          Already have an account?{" "}
          <a href="/" className="text-blue-600">
            Login
          </a>
        </p>
      </form>
    </AuthLayout>
  );
};

export default Register;

const AuthLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <div className="min-h-screen flex">
      {/* Left Side */}
      <div className="w-1/2 bg-blue-600 text-white flex items-center justify-center">
        <div>
          <h1 className="text-4xl font-bold mb-4">FinTrack</h1>
          <p className="text-lg">Manage your finances smartly 💰</p>
        </div>
      </div>

      {/* Right Side */}
      <div className="w-1/2 flex items-center justify-center bg-gray-50">
        {children}
      </div>
    </div>
  );
};

export default AuthLayout;

const Logo = () => {
  return (
    <div className="flex items-center gap-2">
      <svg width="32" height="32" viewBox="0 0 24 24" fill="none">
        <path
          d="M4 20V10M10 20V4M16 20V14M22 20V8"
          stroke="#2563eb"
          strokeWidth="2"
          strokeLinecap="round"
        />
      </svg>

      <span className="text-2xl font-bold text-gray-800">FinTrack</span>
    </div>
  );
};

export default Logo;

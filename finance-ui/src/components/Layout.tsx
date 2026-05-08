const Layout = ({ children }: { children: React.ReactNode }) => {
  return (
    <div className="flex bg-cyan-100 min-h-screen ">
      <div className="flex-1 p-6">{children}</div>
    </div>
  );
};

export default Layout;

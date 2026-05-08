import Layout from "../components/Layout";
import TopCards from "../components/Card";

import Logo from "../components/Logo";
import ExpenseChart from "../components/ExpenseChart";
import CircleChart from "../components/CircleChart";
import PaymentTransactions from "../components/PaymentTransactions";
import CardInfo from "../components/CardInfo";

const Dashboard = () => {
  return (
    <Layout>
      <div className="flex gap-6 p-6 bg-gray-100 min-h-screen">
        {/* LEFT SIDE */}
        <div className="flex-1">
          <div className="relative flex items-center justify-between mb-6">
            {/* LEFT */}
            <h1 className="text-2xl font-bold">Dashboard</h1>

            {/* CENTER */}
            <div className="absolute left-1/2 transform -translate-x-1/2">
              <Logo />
            </div>
          </div>

          {/* Cards */}
          <div className="flex gap-5 mb-6">
            <TopCards title="Salary" amount="$3,120" />
            <TopCards title="Purchase" amount="$5,992" />
            <TopCards title="Investment" amount="$12,488" />
          </div>

          {/* Charts */}
          <div className="flex gap-5 mb-6">
            <div className="flex-1">
              <ExpenseChart />
            </div>

            <div className="w-80">
              <CircleChart />
            </div>
          </div>

          {/* Transactions */}
          <div className="flex gap-5">
            <div className="flex-1">
              <PaymentTransactions />
            </div>
          </div>
        </div>

        {/* RIGHT SIDE PANEL */}
        <div className="w-80">
          <CardInfo />
        </div>
      </div>
    </Layout>
  );
};

export default Dashboard;

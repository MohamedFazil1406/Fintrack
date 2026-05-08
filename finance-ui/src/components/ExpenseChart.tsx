import {
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
  Area,
  AreaChart,
} from "recharts";

const data = [
  { name: "Apr 05", value: 10000 },
  { name: "Apr 06", value: 3000 },
  { name: "Apr 07", value: 2500 },
  { name: "Apr 08", value: 9000 },
  { name: "Apr 09", value: 3500 },
  { name: "Apr 10", value: 5000 },
  { name: "Apr 11", value: 9500 },
];

const ExpenseChart = () => {
  return (
    <div className="bg-white p-5 rounded-xl shadow-sm">
      {/* Header */}
      <div className="flex justify-between items-center mb-4">
        <h3 className="font-semibold text-gray-700">Report Expense</h3>

        <div className="flex gap-2">
          <button className="bg-blue-500 text-white px-3 py-1 rounded-full text-sm">
            📈
          </button>
          <button className="bg-gray-200 px-3 py-1 rounded-full text-sm">
            📊
          </button>
          <select className="border px-3 py-1 rounded-lg text-sm">
            <option>Weekly</option>
          </select>
        </div>
      </div>

      {/* Chart */}
      <div className="h-64">
        <ResponsiveContainer width="100%" height="100%">
          <AreaChart data={data}>
            <defs>
              <linearGradient id="color" x1="0" y1="0" x2="0" y2="1">
                <stop offset="0%" stopColor="#3b82f6" stopOpacity={0.4} />
                <stop offset="100%" stopColor="#3b82f6" stopOpacity={0} />
              </linearGradient>
            </defs>

            <XAxis dataKey="name" />
            <YAxis />
            <Tooltip />

            <Area
              type="monotone"
              dataKey="value"
              stroke="#3b82f6"
              fill="url(#color)"
              strokeWidth={3}
            />
          </AreaChart>
        </ResponsiveContainer>
      </div>

      {/* Footer */}
      <div className="flex justify-between mt-4 text-sm text-gray-500">
        <span>Expense Cumulative →</span>
        <span className="text-green-500">+121.4%</span>
      </div>
    </div>
  );
};

export default ExpenseChart;

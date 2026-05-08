import { RadialBarChart, RadialBar, ResponsiveContainer } from "recharts";

const data = [
  {
    name: "Income",
    value: 8140,
    fill: "#60a5fa", // light blue
  },
  {
    name: "Expense",
    value: 2193,
    fill: "#3b82f6", // dark blue
  },
];

const CircleChart = () => {
  return (
    <div className="bg-white p-6 rounded-xl shadow-sm w-72">
      {/* Chart */}
      <div className="h-56 flex items-center justify-center">
        <ResponsiveContainer width="100%" height="100%">
          <RadialBarChart
            innerRadius="70%"
            outerRadius="100%"
            data={data}
            startAngle={90}
            endAngle={-270}
          >
            <RadialBar dataKey="value" cornerRadius={10} />
          </RadialBarChart>
        </ResponsiveContainer>

        {/* Center Icon */}
        <div className="absolute text-blue-500 text-xl">⚡</div>
      </div>

      {/* Bottom Info */}
      <div className="flex justify-between mt-4 text-sm">
        <div>
          <p className="text-gray-400">Income</p>
          <p className="font-semibold text-blue-500">$8,140</p>
        </div>

        <div>
          <p className="text-gray-400">Expense</p>
          <p className="font-semibold text-blue-700">$2,193</p>
        </div>
      </div>
    </div>
  );
};

export default CircleChart;

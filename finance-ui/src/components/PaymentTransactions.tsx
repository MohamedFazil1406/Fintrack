const transactions = [
  {
    name: "DodoLid",
    desc: "Added storage space 1TB",
    amount: -109.39,
  },
  {
    name: "ZahrPay",
    desc: "Payment to E-commerce",
    amount: -414.11,
  },
];

const PaymentTransactions = () => {
  return (
    <div className="bg-white rounded-xl shadow-sm p-5 w-full max-w-md">
      {/* Header */}
      <div className="flex justify-between items-center mb-4">
        <h3 className="font-semibold text-gray-700">• Payment Transactions</h3>
        <span className="text-gray-400 cursor-pointer">⋯</span>
      </div>

      {/* Amount */}
      <div className="mb-4">
        <h2 className="text-xl font-bold text-gray-800">
          $2,193.21
          <span className="text-sm text-gray-400 ml-2">| This Month</span>
        </h2>
      </div>

      {/* Transactions List */}
      <div className="space-y-3">
        {transactions.map((item, index) => (
          <div
            key={index}
            className="flex items-center justify-between bg-gray-50 p-3 rounded-lg"
          >
            {/* Left */}
            <div className="flex items-center gap-3">
              <div className="w-10 h-10 bg-blue-100 rounded-full flex items-center justify-center text-blue-500">
                💠
              </div>

              <div>
                <p className="font-medium text-gray-700">{item.name}</p>
                <p className="text-xs text-gray-400">{item.desc}</p>
              </div>
            </div>

            {/* Right */}
            <div className="text-right">
              <p className="text-sm font-semibold text-gray-700">
                ${item.amount}
              </p>
              <span className="text-blue-400 text-xs">📈</span>
            </div>
          </div>
        ))}
      </div>

      {/* Footer */}
      <div className="text-center mt-4">
        <button className="text-blue-500 text-sm font-medium hover:underline">
          See Full History
        </button>
      </div>
    </div>
  );
};

export default PaymentTransactions;

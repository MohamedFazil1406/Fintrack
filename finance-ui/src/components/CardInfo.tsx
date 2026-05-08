const CardInfo = () => {
  return (
    <div className="w-80 bg-gray-50 p-5 rounded-2xl">
      {/* Profile */}
      <div className="flex items-center gap-3 mb-6">
        <div className="w-12 h-12 bg-gray-300 rounded-full"></div>
        <div>
          <p className="font-semibold text-gray-700">Hello, Martina Olivera</p>
          <p className="text-xs text-gray-400">Welcome to Bank Aldouser</p>
        </div>
      </div>

      {/* Your Cards */}
      <div className="mb-6">
        <p className="text-sm font-semibold text-gray-600 mb-3">Your Cards</p>

        <div className="bg-linear-to-r from-blue-500 to-blue-700 text-white rounded-xl p-4 shadow-md">
          <p className="text-sm mb-4">ZAHV</p>

          <p className="tracking-widest text-sm mb-4">1101 2001 8723 7001</p>

          <div className="flex justify-between text-xs">
            <div>
              <p className="text-gray-200">Name Card</p>
              <p>Martina O</p>
            </div>

            <div>
              <p className="text-gray-200">Expired Date</p>
              <p>06/27</p>
            </div>
          </div>
        </div>
      </div>

      {/* Card Info */}
      <div className="mb-6">
        <p className="text-sm font-semibold text-gray-600 mb-3">Card Info</p>

        <div className="text-sm space-y-2">
          <div className="flex justify-between">
            <span className="text-gray-400">Card Number</span>
            <span>1101 ****</span>
          </div>

          <div className="flex justify-between">
            <span className="text-gray-400">Balance</span>
            <span>$12,941.10</span>
          </div>

          <div className="flex justify-between">
            <span className="text-gray-400">Currency</span>
            <span>USD</span>
          </div>

          <div className="flex justify-between">
            <span className="text-gray-400">Status Card</span>
            <span>11/24 (Active)</span>
          </div>
        </div>
      </div>

      {/* Card Limits */}
      <div>
        <p className="text-sm font-semibold text-gray-600 mb-3">Card Limits</p>

        {/* Business Credit */}
        <div className="bg-white p-3 rounded-xl mb-3 flex justify-between items-center shadow-sm">
          <div className="flex items-center gap-3">
            <div className="flex gap-1">
              <div className="w-2 h-6 bg-pink-500 rounded"></div>
              <div className="w-2 h-8 bg-blue-400 rounded"></div>
              <div className="w-2 h-5 bg-blue-600 rounded"></div>
            </div>

            <div>
              <p className="text-xs text-gray-400">Business Credit</p>
              <p className="text-sm font-semibold">$2,000 / $5,000</p>
            </div>
          </div>

          <span>›</span>
        </div>

        {/* Personal Credit */}
        <div className="bg-white p-3 rounded-xl flex justify-between items-center shadow-sm">
          <div className="flex items-center gap-3">
            <div className="flex gap-1">
              <div className="w-2 h-6 bg-blue-300 rounded"></div>
              <div className="w-2 h-8 bg-blue-500 rounded"></div>
              <div className="w-2 h-5 bg-blue-700 rounded"></div>
            </div>

            <div>
              <p className="text-xs text-gray-400">Personal Credit</p>
              <p className="text-sm font-semibold">$1,400 / $2,600</p>
            </div>
          </div>

          <span>›</span>
        </div>
      </div>
    </div>
  );
};

export default CardInfo;

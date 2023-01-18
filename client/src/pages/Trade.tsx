import { Card } from "antd";
import React from "react";

export default function Trade() {
  return (
    <div className="p-4 px-6 md:max-w-[1000px] mx-auto">
      {/* Portfolio */}
      <div className="grid md:grid-cols-4 gap-2">
        <Card title="Portfolio" className="col-span-3">
          <div className="mb-2 border-b border-gray-100">This will have the summarized report of your holdings.</div>
          <div className="grid grid-cols-3">
            <div className="flex space-x-2">
              <div>Total invested: </div>
              <div>1000 </div>
            </div>
            <div className="flex space-x-2">
              <div>Current Value: </div>
              <div>1000 </div>
            </div>
            <div className="flex space-x-2">
              <div>Profit: </div>
              <div>1000 </div>
            </div>
          </div>
        </Card>
        <Card title="Net returns">
          <div className="text-center text-3xl font-bold text-green-400">
            13%
          </div>
        </Card>
      </div>
    </div>
  );
}

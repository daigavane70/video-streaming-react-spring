import { Card, List } from "antd";
import axios, { AxiosResponse } from "axios";
import React, { useEffect, useState } from "react";
import StockTile from "../components/StockTile";
import { HttpApiResponse, StocksInterface } from "../utils/interfaces";
import { getAllStocks } from "../utils/requests";

export default function Trade() {
  const [stocks, setStocks] = useState<StocksInterface[]>([]);

  useEffect(() => {
    getAllStocks()
      .then((response) => {
        console.log("got the stocks response as: ", stocks);
        setStocks(response.data.data);
      })
      .catch((e) => {
        console.error("unable to get the stocks");
      });
  }, []);

  return (
    <div className="p-4 px-6 md:max-w-[1000px] mx-auto space-y-2">
      {/* Portfolio */}
      <div className="grid md:grid-cols-4 gap-2">
        <Card
          title={<div className=" text-blue-600">Portfolio</div>}
          className="col-span-3"
        >
          <div className="mb-2 border-b border-gray-100">
            This will have the summarized report of your holdings.
          </div>
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

      <Card title={<div>All Stocks</div>}>
        <List>
          {stocks.length > 0 &&
            stocks.map((stock) => {
              return <StockTile stock={stock}></StockTile>;
            })}
        </List>
      </Card>
    </div>
  );
}

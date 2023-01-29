import { LoadingOutlined } from "@ant-design/icons";
import { Card, List, Spin } from "antd";
import React, { useEffect, useState } from "react";
import { StocksInterface } from "../utils/interfaces";
import { getStockById } from "../utils/requests";

export default function StockTile({ stock }: { stock: StocksInterface }) {
  const [price, setPrice] = useState<number>(0);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    setInterval(() => {
      getStockById(stock.id)
        .then((response) => {
          const newPrice = response?.data?.data?.price;
          setLoading(false);
          setPrice(newPrice);
        })
        .catch((e) => {
          console.error("unable to get the stocks");
        });
    }, 2000);
  }, []);
  return (
    <Spin spinning={loading} indicator={<LoadingOutlined></LoadingOutlined>}>
      <List.Item>
        <div className="grid grid-cols-2 w-full">
          <div>{stock.name}</div>
          <div>{price}</div>
        </div>
      </List.Item>
    </Spin>
  );
}

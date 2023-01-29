import axios from "axios";
import { HttpApiResponse, StocksInterface } from "./interfaces";

const axiosInstance = axios.create({ baseURL: "http://localhost:5080/api" });

export const getStockById = (id: number) => {
  return axiosInstance.get<HttpApiResponse<StocksInterface>>("/stocks/" + id);
};

export const getAllStocks = () => {
  return axiosInstance.get<HttpApiResponse<StocksInterface[]>>("/stocks");
};

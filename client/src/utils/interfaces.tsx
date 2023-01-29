export interface HttpApiResponse<T> {
  success: boolean;
  data: T;
  error: ErrorInterface;
}

export interface StocksInterface {
  id: number;
  name: String;
  price: number;
  totalShares: number;
  outstandingShares: number;
}

export interface ErrorInterface {
  code: number;
  message: String;
}

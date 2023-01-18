import "./App.css";
import "antd/dist/reset.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import React from "react";
import Trade from "./pages/Trade";
import Navbar from "./components/Navbar";

function App() {
  return (
    <div className=" font-extralight">
      <Navbar></Navbar>
      <Routes>
        <Route path="/trade" element={<Trade></Trade>}></Route>
        <Route path="" element={<Home></Home>}></Route>
      </Routes>
    </div>
  );
}

export default App;

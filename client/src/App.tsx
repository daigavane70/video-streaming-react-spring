import "./App.css";
import "antd/dist/reset.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import React from "react";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="" element={<Home></Home>}></Route>
      </Routes>
    </div>
  );
}

export default App;

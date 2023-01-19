import { Button } from "antd";
import React from "react";
import { NavLink } from "react-router-dom";

const navbarClasses = " text-white rounded-0";

export default function Navbar() {
  return (
    <div className="flex flex-row items-center px-6 bg-black w-full space-x-4 h-[60px]">
      <NavLink to={"/"}>
        <Button className={navbarClasses}>Home</Button>
      </NavLink>
      <NavLink to={"/trade"}>
        <Button className={navbarClasses}>Trade</Button>
      </NavLink>
      <NavLink to={"/video"}>
        <Button className={navbarClasses}>Video</Button>
      </NavLink>
    </div>
  );
}

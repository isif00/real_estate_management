"use client";

import { Sidebar } from "flowbite-react";
import { HiChartPie, HiUser, HiViewBoards } from "react-icons/hi";
import { FaHouse } from "react-icons/fa6";

import "./SideNavBar.css";

export default function SideNavBar(){
  const customTheme= {
    root: {
      base: 'bg-gray-800',
      inner: 'bg-gray-800',
    }
  } 
  return (
    <div className="sidebar-container"> 
      <Sidebar aria-label="Default sidebar example" theme={customTheme}> 
        <Sidebar.Items>
          <Sidebar.ItemGroup>
            <Sidebar.Item href="#" icon={HiChartPie} className="text-white">
              Dashboard
            </Sidebar.Item>
            <Sidebar.Item href="#" icon={HiUser} className="text-white"> 
              Clients
            </Sidebar.Item>
            <Sidebar.Item href="#" icon={FaHouse} className="text-white">
              RealEstates
            </Sidebar.Item>
            <Sidebar.Item href="#" icon={HiViewBoards} className="text-white">
              Transactions
            </Sidebar.Item>
          </Sidebar.ItemGroup>
        </Sidebar.Items>
      </Sidebar>
    </div>
  );
}


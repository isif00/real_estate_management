"use client";

import { Navbar } from "flowbite-react";
import "./NavBar.css";

export function NavBar() {
  return (
    <Navbar
      fluid
      rounded={false}
      className="bg-gray-800 text-white px-3 py-4"
    >
      <div className="flex justify-end items-center w-full">
        <Navbar.Collapse className="flex items-center justify-end space-x-10">
          <Navbar.Link href="#"  className="text-white">About us</Navbar.Link>
          <Navbar.Link href="#"  className="text-white">Contact</Navbar.Link>
        </Navbar.Collapse>
      </div>
    </Navbar>
  );
}

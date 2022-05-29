

import React, { useState } from "react";
import {
  ProSidebar,
  Menu,
  MenuItem,
  SubMenu,
  SidebarHeader,
  SidebarFooter,
  SidebarContent,
} from "react-pro-sidebar";
import { FiLogOut, FiArrowLeftCircle, FiArrowRightCircle, FiBookOpen } from "react-icons/fi";
import { MdAccountCircle, MdDashboard } from "react-icons/md";
import { BiCog} from "react-icons/bi";
import { BsBook} from "react-icons/bs";
import "react-pro-sidebar/dist/css/styles.css";
import "./Sidebar.css";
import { Link } from 'react-router-dom';



const Sidebar = (props) => {
  const courses = p
  return (
    <>
      <div id="sidebar">
        <ProSidebar>
          <SidebarContent>
            <Menu iconShape="square">
              <MenuItem icon={<MdAccountCircle />}>
                My Account
              </MenuItem>
              <MenuItem icon={<MdDashboard />}>
                <a href="/dashboards"> Dashboards </a>
              </MenuItem>

              <SubMenu color ="white" title="Courses"  icon={<FiBookOpen/>}>
                <MenuItem >
                  <a href="/course1">Cloud</a>
                </MenuItem>
                <MenuItem >
                  <a href="/course2">Web</a>
                </MenuItem>
              </SubMenu>
              <MenuItem icon={<BiCog />}>Settings</MenuItem>
            </Menu>
          </SidebarContent>

          <SidebarFooter>
            <Menu iconShape="square">
              <MenuItem icon={<FiLogOut />}>
                <a href="/login"> Log Out </a>
              </MenuItem>
            </Menu>
          </SidebarFooter>

        </ProSidebar>
      </div>
    </>
  );
};

export default Sidebar;


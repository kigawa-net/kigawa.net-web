import {Route, Routes} from "react-router-dom";
import {getPageJson} from "../hooks/rootJson";
import {Service} from "./service/service";
import {Top} from "./service/Top";
import React from "react";

export function Contents() {
    return <Routes>
        <Route path={getPageJson("service").pagePath} element={<Service/>}/>
        <Route path={"/*"} element={<Top/>}/>
    </Routes>
}
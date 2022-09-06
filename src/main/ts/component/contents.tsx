import {Route, Routes} from "react-router-dom";
import {Service} from "./service/service";
import {Top} from "./service/top";
import React from "react";

export function Contents() {
    return <Routes>
        <Route path={"/app/service"} element={<Service/>}/>
        <Route path={"/*"} element={<Top/>}/>
    </Routes>
}
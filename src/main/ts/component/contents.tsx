import {Route, Routes} from "react-router-dom";
import {Service} from "./service/service";
import {Top} from "./service/top";
import React from "react";

export function Contents() {
    return <Routes>
        <Route path={Pages.service} element={<Service/>}/>
        <Route path={"/*"} element={<Top/>}/>
    </Routes>
}

export const Pages = {
    top: "/",
    service: "/app/service",
} as const;
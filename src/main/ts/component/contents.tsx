import {Route, Routes} from "react-router-dom";
import {Services} from "./service/services";
import {Top} from "./service/top";
import React from "react";

export function Contents() {
    return <Routes>
        <Route path={Pages.service} element={<Services/>}/>
        <Route path={"/*"} element={<Top/>}/>
    </Routes>
}

export const Pages = {
    top: "/",
    service: "/app/service",
} as const;
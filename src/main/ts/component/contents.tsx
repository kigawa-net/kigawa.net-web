import {Route, Routes} from "react-router-dom";
import {ServiceList} from "./service/serviceList";
import React from "react";
import {Service} from "./service/service";
import {useService} from "../hooks/serviceHook";

export function Contents() {
    return <Routes>
        <Route path={Pages.service} element={<ServiceList/>}/>
        <Route path={"/*"} element={<Service strId="top"/>}/>
    </Routes>
}

export const Pages = {
    top: "/",
    service: "/app/service",
} as const;
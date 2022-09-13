import React from "react";
import {useTheme} from "../hooks/themeHook";
import {Link} from "react-router-dom";
import {siteName} from "../bundle";
import {Pages} from "./contents";

interface Prop {
}

export function Logo(props: Prop) {
    return <div className={
        useTheme().text_accent
        + " text-center w-32"
        + " text-xl"
    }>
        <Link to={Pages.top}>{siteName}</Link>
    </div>
}
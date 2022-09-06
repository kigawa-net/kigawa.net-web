import React from "react";
import {useTheme} from "../hooks/theme";
import {Link} from "react-router-dom";
import {siteName} from "../bundle";

interface Prop {
}

export function Logo(props: Prop) {
    return <div className={
        useTheme().text_accent
        + " text-center w-32"
        + " text-xl"
    }>
        <Link to={"/"}>{siteName}</Link>
    </div>
}
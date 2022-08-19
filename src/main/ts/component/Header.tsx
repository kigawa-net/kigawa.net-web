import React from "react";
import {useTheme} from "../hooks/theme";
import {Logo} from "./Logo";
import {Link} from "react-router-dom";
import {getPageJson} from "../hooks/rootJson";

interface Prop {
}

export function Header(props: Prop) {
    const theme = useTheme()
    return <div className={
        theme.bg_accent_sub
        + " h-10"
        + " bg-opacity-70"
        + " p-1"
    }>
        <Logo/>

        <Link to={getPageJson("service").pagePath}>
            <p>Services</p>
        </Link>
    </div>
}

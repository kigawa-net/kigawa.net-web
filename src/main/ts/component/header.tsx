import React from "react";
import {useTheme} from "../hooks/theme";
import {Logo} from "./logo";
import {Link} from "react-router-dom";
import {Pages} from "./contents";

interface Prop {
}

export function Header(props: Prop) {
    const theme = useTheme()

    return <div className={
        theme.bg_accent
        + " bg-opacity-70 h-10 p-1"
        + " flex text-center"
    }>
        <div className={"mr-16"}>
            <Logo/>
        </div>

        <div className={" w-32 text-xl bg-opacity-70"
            + useTheme().text_accent
            + useTheme().bg_accent_sub}>
            <Link to={Pages.service}>
                <p>Services</p>
            </Link>
        </div>
    </div>
}

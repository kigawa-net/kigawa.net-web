import React from "react";
import {useTheme} from "../hooks/themeHook";
import {Link} from "react-router-dom";
import {siteName} from "../bundle";
import {Pages} from "./contents";

interface Prop {
}

export function Logo(props: Prop) {
    const theme = useTheme()
    return <div className={" text-center w-32 text-xl"}
                style={{color: theme.text_accent}}>
        <Link to={Pages.top}>{siteName}</Link>
    </div>
}
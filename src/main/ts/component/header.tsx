import React from "react";
import {useTheme} from "../hooks/themeHook";
import {Logo} from "./logo";
import {Link} from "react-router-dom";
import {Pages} from "./contents";

interface Prop {
}

export function Header(props: Prop) {
    const theme = useTheme()

    return <div className={" bg-opacity-70 h-10 p-1 flex text-center"}
                style={{backgroundColor: theme.bg_accent}}>
        <div className={"mr-16"}>
            <Logo/>
        </div>

        <div className={" w-32 text-xl bg-opacity-70"}
             style={{backgroundColor: theme.bg_accent_sub, color: theme.text_accent}}>
            <Link to={Pages.service}>
                <p>Services</p>
            </Link>
        </div>
    </div>
}

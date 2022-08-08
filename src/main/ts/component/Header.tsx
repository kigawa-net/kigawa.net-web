import React from "react";
import {useTheme} from "../theme/theme";
import {Logo} from "./Logo";


export function Header(props: any) {
    const theme = useTheme()
    return <div className={
        theme.bg_accent_sub
        + " h-10"
        + " bg-opacity-70"
        + " p-1"
    }>
        <Logo rootJson={props.rootJson}/>
    </div>
}

import React from "react";
import {useTheme} from "../theme/theme";
import {Logo} from "./Logo";


export const Header = () => {
    const theme = useTheme()
    return <div className={
        theme.bg_accent_sub
        + " h-10"
        + " bg-opacity-70"
        + " p-1"
    }>
        <Logo/>
    </div>
}

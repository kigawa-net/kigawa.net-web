import React from "react";
import {siteName} from "../bundle";
import {useTheme} from "../theme/theme";

export const Logo = () => {
    return <div className={
        useTheme().text_accent
        + " text-center w-32"
        + " text-xl"
        + " ml-1 mt-1"
    }>
        <a>{siteName()}</a>
    </div>
}
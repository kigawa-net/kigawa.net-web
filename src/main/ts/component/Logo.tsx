import React from "react";
import {siteName} from "../bundle";
import {useTheme} from "../theme/theme";

export function Logo(props: any) {
    const url = props.rootJson ? props.rootJson.homeUrl : ""

    return <div className={
        useTheme().text_accent
        + " text-xl"
    }>
        <a href={url}>{siteName}</a>
    </div>
}
import React from "react";
import {RootJson, siteName} from "../bundle";
import {useTheme} from "../theme/theme";
import {Link} from "react-router-dom";

interface Prop {
    rootJson: RootJson
}

export function Logo(props: Prop) {
    const url = props.rootJson ? props.rootJson.homeUrl : ""

    return <div className={
        useTheme().text_accent
        + " text-center w-32"
        + " text-xl"
    }>
        <Link to={url}>{siteName}</Link>
    </div>
}
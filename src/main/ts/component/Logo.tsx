import React from "react";
import {useTheme} from "../hooks/theme";
import {Link} from "react-router-dom";
import {siteName} from "../bundle";
import {getPageJson, useRootJson} from "../hooks/rootJson";

interface Prop {
}

export function Logo(props: Prop) {
    return <div className={
        useTheme().text_accent
        + " text-center w-32"
        + " text-xl"
    }>
        <Link to={getPageJson("top").pageUrl}>{siteName}</Link>
    </div>
}
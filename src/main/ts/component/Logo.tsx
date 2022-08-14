import React from "react";
import {useTheme} from "../theme";
import {Link} from "react-router-dom";
import {siteName} from "../bundle";
import {useRootJson} from "../rootJson";

interface Prop {
}

export function Logo(props: Prop) {
    return <div className={
        useTheme().text_accent
        + " text-center w-32"
        + " text-xl"
    }>
        <Link to={useRootJson().sitemap.topPage}>{siteName}</Link>
    </div>
}
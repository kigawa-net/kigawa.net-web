import React from "react";
import {useTheme} from "../theme/theme";
import {Link} from "react-router-dom";
import {RootJson} from "../Json";
import {siteName} from "../bundle";

interface Prop {
    rootJson: RootJson
}

export function Logo(props: Prop) {
    return <div className={
        useTheme().text_accent
        + " text-center w-32"
        + " text-xl"
    }>
        <Link to={props.rootJson.homePage}>{siteName}</Link>
    </div>
}
import {useTheme} from "../theme/theme";
import React from "react";
import {Header} from "./Header";
import {RootJson} from "../bundle";

interface Prop {
    rootJson: RootJson
}

export function Home(props: Prop) {
    return <div className={useTheme().bg_back + " h-full"}>
        <p>aaaaa</p>
    </div>
}
import {useTheme} from "../theme/theme";
import React from "react";
import {Header} from "./Header";

export function Home(props: any) {
    return <div className={useTheme().bg_back + " h-full"}>
        <Header rootJson={props.rootJson}/>
        <p>aaaaa</p>
    </div>
}
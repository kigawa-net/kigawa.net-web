import {useTheme} from "../theme/theme";
import React from "react";
import {getHomeJson, HomeJson, RootJson} from "../Json";
import {useRest} from "../util";
import {siteName} from "../bundle";

interface Prop {
    rootJson: RootJson
}

export function Home(props: Prop) {
    const homeJson: HomeJson = useRest(
        props.rootJson.homeRest,
        getHomeJson,
    )

    return <div className={useTheme().bg_back}>
        <div className={"pb-1"}>
            <img src={homeJson.topImg} className={""}/>
            <p className={
                "mt-16 mb-16 w-full text-5xl text-center"+useTheme().text_accent
            }>{siteName}</p>
        </div>
    </div>
}
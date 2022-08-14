import {useTheme} from "../../theme";
import React from "react";
import {getTopJson, TopJson, RootJson} from "../../json";
import {useRest} from "../../util";
import {siteName} from "../../bundle";

interface Prop {
    rootJson: RootJson
}

export function Top(props: Prop) {
    const topJson: TopJson = useRest(
        props.rootJson.topRest,
        getTopJson,
    )

    return <div className={useTheme().bg_back}>
        <div className={"pb-1"}>
            <img src={topJson.topImg} className={""}/>
            <p className={
                "mt-16 mb-16 w-full text-5xl text-center"+useTheme().text_accent
            }>{siteName}</p>
        </div>
    </div>
}
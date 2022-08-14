import {useTheme} from "../../theme";
import React from "react";
import {initTopJson, TopJson} from "../../json";
import {useRest} from "../../util";
import {siteName} from "../../bundle";
import {useRootJson} from "../../rootJson";

interface Prop {
}

export function Top(props: Prop) {
    const topJson: TopJson = useRest(
        useRootJson().sitemap.topRest,
        initTopJson,
    )

    return <div className={useTheme().bg_back}>
        <div className={"pb-1"}>
            <img src={topJson.topImg} className={""}/>
            <p className={
                "mt-16 mb-16 w-full text-5xl text-center" + useTheme().text_accent
            }>{siteName}</p>
        </div>
    </div>
}
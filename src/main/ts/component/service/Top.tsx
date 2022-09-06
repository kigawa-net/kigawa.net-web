import {useTheme} from "../../hooks/theme";
import React from "react";
import {initTopJson, TopJson} from "../../response/json";
import {useJson} from "../../hooks/jsonHook";
import {siteName} from "../../bundle";
import {getPageJson, useRootJson} from "../../hooks/rootJson";

interface Prop {
}

export function Top(props: Prop) {
    const topJson: TopJson = useJson(
        getPageJson("top").restUrl,
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
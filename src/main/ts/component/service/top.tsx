import {useTheme} from "../../hooks/themeHook";
import React from "react";
import {siteName} from "../../bundle";
import {useRootJson} from "../../hooks/rootJsonHook";
import {getService} from "../../hooks/serviceHook";

interface Prop {
}

export function Top(props: Prop) {

    return <div className={useTheme().bg_back}>
        <div className={"pb-1"}>
            <img src={getService("top").topImg} className={""}/>
            <p className={
                "mt-16 mb-16 w-full text-5xl text-center" + useTheme().text_accent
            }>{siteName}</p>
        </div>
    </div>
}
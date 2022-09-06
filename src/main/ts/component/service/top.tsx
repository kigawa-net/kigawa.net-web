import {useTheme} from "../../hooks/theme";
import React from "react";
import {siteName} from "../../bundle";
import {Images, initImages} from "../../response/json";
import {useJson} from "../../hooks/jsonHook";
import {useRootJson} from "../../hooks/rootJson";

interface Prop {
}

export function Top(props: Prop) {
    const images: Images = useJson(useRootJson().imagesUrl, initImages)

    return <div className={useTheme().bg_back}>
        <div className={"pb-1"}>
            <img src={images.topImg} className={""}/>
            <p className={
                "mt-16 mb-16 w-full text-5xl text-center" + useTheme().text_accent
            }>{siteName}</p>
        </div>
    </div>
}
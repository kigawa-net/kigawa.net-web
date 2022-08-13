import {useTheme} from "../theme/theme";
import React from "react";
import {getHomeJson, HomeJson, RootJson} from "../Json";
import {useRest} from "../util";

interface Prop {
    rootJson: RootJson
}

export function Home(props: Prop) {
    const homeJson: HomeJson = useRest(
        props.rootJson.homeRest,
        getHomeJson(),
    )

    return <div className={useTheme().bg_back}>
        <div>
            <img src={homeJson.topImg}/>
        </div>
    </div>
}
import React from "react";
import {useJson} from "../../hooks/jsonHook";
import {useRootJson} from "../../hooks/rootJsonHook";
import {initServiceList} from "../../response/json";
import {useTheme} from "../../hooks/themeHook";
import {ButtonFrame} from "../util/elements";

interface Prop {
}

export function ServiceList(prop: Prop) {
    const services = useJson(useRootJson().serviceList, initServiceList)
    const theme = useTheme()
    const elements: JSX.Element[] = []

    for (const service of services.serviceList) {
        elements.push(
            <ButtonFrame inClass={"w-48 h-48"} outClass={"m-5"} key={service.strId}
                         inStyle={{borderColor: theme.accent3}}>
                <h2 className={"text-center my-auto text-xl"}>
                    {service.title}
                </h2>
            </ButtonFrame>
        )
    }

    return <div className={" max-w-4xl mx-auto"}>
        <h1 style={{color: theme.reverse}}
            className={" text-6xl text-center"}>services</h1>
        <div className={" flex"}>
            {elements}
        </div>
    </div>
}
import React from "react";
import {useTheme} from "../../hooks/themeHook";
import {useService} from "../../hooks/serviceHook";
import {BlockFrame, ButtonFrame} from "../util/elements";
import {Buffer} from "buffer";

interface Prop {
    strId: string
}

export function Service(prop: Prop) {
    const service = useService(prop.strId)
    const theme = useTheme()

    return <div className="" style={{backgroundColor: theme.base}}>
        <div className={" pt-60 h-160"} style={{backgroundImage: "url(" + service.topImg + ")"}}>
            <BlockFrame inClass={"w-min px-10"} outClass={"mx-auto"}>
                <h1 className={" text-7xl text-center"} style={{color: service.titleColor}}>
                    {service.title}
                </h1>
            </BlockFrame>
        </div>
    </div>
}
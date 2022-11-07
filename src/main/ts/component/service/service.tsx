import React from "react";
import {initService, initTheme} from "../../response/json";
import {BlockFrame} from "../util/elements";
import {useService} from "../../hooks/serviceHook";
import {useTheme} from "../../hooks/themeHook";

interface Prop {
    strId: string
}

export function Service(prop: Prop) {
    console.log("service")
    const service = useService(prop.strId)
    // const service = initService()
    // const theme = useTheme()
    const theme = initTheme()


    return <div className="" style={{backgroundColor: theme.base}}>
        <div className={" pt-60 h-160"} style={{backgroundImage: "url(" + service.topImg + ")"}}>
            <BlockFrame inClass={"px-10"}
                        outClass={"mx-auto"} outWidthClass={"w-2/4"}>
                <h1 className={" text-7xl text-center"} style={{color: service.titleColor}}>
                    {service.title}
                </h1>
            </BlockFrame>
            <BlockFrame inClass={"px-10"}
                        outClass={"mt-2 mx-auto"} outWidthClass={"w-1/3"}
                        backColor={theme.base} frameColor={theme.accent}>
                <h2 className={"text-2xl text-center"}>
                    {service.description}
                </h2>
            </BlockFrame>
        </div>
    </div>
}
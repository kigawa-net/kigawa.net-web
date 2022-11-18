import React from "react";
import {BlockFrame} from "../util/elements";
import {useService} from "../../hooks/serviceHook";
import {useTheme} from "../../hooks/themeHook";

interface Prop {
    strId: string
}

export function Service(prop: Prop) {
    const service = useService(prop.strId)
    const theme = useTheme()


    return <div className="" style={{backgroundColor: theme.base}}>
        <div className={"h-160 flex items-center"} style={{backgroundImage: "url(" + service.topImg + ")"}}>
            <div className={"w-full"}>
                <BlockFrame inClass={"px-10"} outClass={"mx-auto"} outWidthClass={"w-2/4"}>
                    <h1 className={"text-7xl text-center"} style={{color: service.titleColor}}>
                        {service.title}
                    </h1>
                </BlockFrame>
                <BlockFrame inClass={"px-10"}
                            outClass={"mt-2 mx-auto"} outWidthClass={"w-1/3"}
                            backColor={theme.base} frameColor={theme.accent}>
                    <h2 className={"text-2xl text-center"}>
                        {service.subtitle}
                    </h2>
                </BlockFrame>
            </div>
        </div>
    </div>
}

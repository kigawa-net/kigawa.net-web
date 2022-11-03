import React from "react";
import {useTheme} from "../../hooks/themeHook";
import {useService} from "../../hooks/serviceHook";

interface Prop {
    strId: string
}

export function Service(prop: Prop) {
    const service = useService(prop.strId)

    return <div className={useTheme().bg_back+" pt-40"}
                style={{backgroundImage: "url(" + service.topImg + ")"}}>
        <div className={""}>
            <h1 className={
                "mb-16 w-full text-7xl text-center" + useTheme().text_accent
            }>{service.title}</h1>
        </div>
    </div>
}
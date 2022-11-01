import React from "react";
import {useTheme} from "../../hooks/themeHook";
import {useService} from "../../hooks/serviceHook";

interface Prop {
    strId: string
}

export function Service(prop: Prop) {
    const service = useService(prop.strId)

    return <div className={useTheme().bg_back}>
        <div className={"pb-1"}>
            <img src={service.topImg} className={""} alt="top img"/>
            <p className={
                "mt-16 mb-16 w-full text-5xl text-center" + useTheme().text_accent
            }>{service.title}</p>
        </div>
    </div>
}
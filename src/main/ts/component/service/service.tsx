import React from "react";
import {useTheme} from "../../hooks/themeHook";
import {useService} from "../../hooks/serviceHook";

interface Prop {
    strId: string
}

export function Service(prop: Prop) {
    const service = useService(prop.strId)
    const theme = useTheme()

    return <div className="" style={{backgroundColor: theme.bg}}>
        <div className={" pt-60 h-160"} style={{backgroundImage: "url(" + service.topImg + ")"}}>
            <div className={" mx-auto w-min p-1"} style={{backgroundColor: theme.bg}}>
                <div className={" px-10 p-2 border-4"}>
                    <h1 className={" text-7xl text-center"} style={{color: service.titleColor}}>
                        {service.title}
                    </h1>
                </div>
            </div>
        </div>
    </div>
}
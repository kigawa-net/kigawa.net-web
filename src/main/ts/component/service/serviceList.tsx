import React from "react";
import {useJson} from "../../hooks/jsonHook";
import {useRootJson} from "../../hooks/rootJsonHook";
import {initServiceList} from "../../response/json";

interface Prop {
}

export function ServiceList(prop: Prop) {
    const services = useJson(useRootJson().serviceList, initServiceList)

    const elements: JSX.Element[] = []

    for (const service of services.serviceList) {
        elements.push(<div className={""}>
            {service.title}
        </div>)
    }

    return <div className={"flex content-center"}>
        {elements}
    </div>
}
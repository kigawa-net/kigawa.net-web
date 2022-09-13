import React from "react";
import {useJson} from "../../hooks/jsonHook";
import {useRootJson} from "../../hooks/rootJsonHook";
import {initServiceList} from "../../response/json";

interface Prop {
}

export function Services(prop: Prop) {
    const services = useJson(useRootJson().serviceList, initServiceList)

    const elements: JSX.Element[] = []

    for (const service of services.serviceMap) {
        elements.push(<div className={""}>
        </div>)
    }

    return <div className={"flex content-center"}>
        {elements}
    </div>
}
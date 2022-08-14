import React from "react";
import {getServiceJson, ServiceJson, ServicesJson} from "../../json";
import {useRest} from "../../util";
import {Link} from "react-router-dom";
import {useSitemap} from "../../rootJson";

interface Prop {
}

export function Service(prop: Prop) {
    const servicesJson: ServicesJson = useRest(useSitemap().sitemap.servicesRest, getServiceJson)
    const services = servicesJson.services.map((serviceJson: ServiceJson) => {
        return <div className={"w-16 h-16"}>
            <Link to={serviceJson.servicePage}>
                <p>{serviceJson.name}</p>
            </Link>
        </div>
    })


    return <div className={"flex content-center"}>
        {services}
    </div>
}
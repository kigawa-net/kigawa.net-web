import React, {Context, useContext, useEffect, useState} from "react";
import {fetchJson} from "./util";

export interface RootJson {
    sitemap: Sitemap
}

function getRootJson(): RootJson {
    return {
        sitemap: getSitemap()
    }
}

export interface Sitemap {
    topPage: string
    topRest: string
    servicesPage: string
    servicesRest: string
}

function getSitemap(): Sitemap {
    return {
        topRest: "",
        topPage: "",
        servicesPage: "",
        servicesRest: "",
    }
}

const RootJsonContext: Context<RootJson> = React.createContext(getRootJson())
let setRootJson: (rootJson: RootJson) => void = () => {
}

export async function fetchRootJson() {
    fetchJson(
        document.getElementById("baseurl").innerText,
        setRootJson
    )

}

export function RootJsonProvider(props: any) {
    const [rootJson, setState] = useState(getRootJson)
    setRootJson = setState
    useEffect(() => {
        fetchRootJson().then()
    }, [setRootJson])


    return <RootJsonContext.Provider value={rootJson}>
        {props.children}
    </RootJsonContext.Provider>
}

export function useSitemap(): RootJson {
    return useContext(RootJsonContext)
}
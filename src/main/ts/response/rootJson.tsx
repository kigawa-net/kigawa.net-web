import React, {Context, useContext, useEffect, useState} from "react";
import {fetchJson} from "../util";

export interface RootJson {
    sitemap: Page[]
}

function initRootJson(): RootJson {
    return {
        sitemap: [initPage()]
    }
}

export interface Page {
    name: string
    pageUrl: string
    restUrl: string
}

function initPage(): Page {
    return {
        name: "",
        pageUrl: "",
        restUrl: ""
    }
}

export function getPageJson(name: string): Page {
    const page = useRootJson().sitemap.find((value) => value.name == name)
    if (page) return page
    return initPage()
}


const RootJsonContext: Context<RootJson> = React.createContext(initRootJson())
let setRootJson: (rootJson: RootJson) => void = () => {
}

export async function fetchRootJson() {
    fetchJson(
        document.getElementById("baseurl").innerText,
        setRootJson
    )

}

export function RootJsonProvider(props: any) {
    const [rootJson, setState] = useState<RootJson>()
    setRootJson = setState
    useEffect(() => {
        fetchRootJson().then()
    }, [setRootJson])

    const rootJson1 = rootJson ? rootJson : initRootJson()

    return <RootJsonContext.Provider value={rootJson1}>
        {props.children}
    </RootJsonContext.Provider>
}

export function useRootJson(): RootJson {
    return useContext(RootJsonContext)
}
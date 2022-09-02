import React, {Context, useContext, useEffect, useState} from "react";
import {fetchJson} from "../util/util";
import {initPage, initRootJson, Page, RootJson} from "../response/json";

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
        setRootJson,
        initRootJson
    )

}

export function RootJsonProvider(props: any) {
    const [rootJson, setState] = useState<RootJson>(initRootJson)
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
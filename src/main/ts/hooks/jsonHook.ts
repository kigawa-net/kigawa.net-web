import {createURL, getValue} from "../util/util";
import {UrlString} from "../response/json";
import {useEffect, useState} from "react";
import {debug} from "../bundle";

export function fetchJson<T = any>(url: URL | UrlString, setState: (state: any) => void, defaultValue: T | (() => T)) {
    if (url == undefined) return getValue(defaultValue)
    url = createURL(url)
    const currentUrl = createURL(window.location.href)

    if (url.host == currentUrl.host) {
        url.protocol = currentUrl.protocol
    }

    if (debug) console.debug("fetch: " + url)

    fetch(url)
        .then((res: Response) => {
            if (!res.ok) {
                console.error(res.statusText)
                return;
            }
            res.json().then((json) => {
                if (debug) console.debug(json)
                setState(json)
            }).catch((reason) => {
                console.error(url + ": " + reason)
            })
        })
}

export function useJson<T = any>(url: URL | UrlString, defaultValue: T | (() => T)): T {
    if (url == undefined) return getValue(defaultValue)
    if (!(url instanceof URL)) url = createURL(url)
    const [restObj, setObj] = useState<T>()

    useEffect(() => {
        if (!url) return
        fetchJson<T>(url, setObj, defaultValue)
    }, [url.href, setObj])

    if (restObj) return restObj

    return getValue(defaultValue)
}
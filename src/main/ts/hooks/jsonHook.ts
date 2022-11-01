import {useEffect, useState} from "react";
import {Url} from "../response/json";
import {debug} from "../bundle";

export function fetchJson<T = any>(url: string, setState: (state: any) => void, defaultValue: T | (() => T)) {
    if (url == "") return
    if (url.indexOf("://") != -1) {
        const urlHead = window.location.href.split("://")[0]
        url = urlHead + "://" + url.split("://")[0]
    }
    fetch(url)
        .then((res: Response) => {
            if (!res.ok) {
                setState(defaultValue instanceof Function ? defaultValue() : defaultValue)
                return;
            }
            res.json().then((res) => {
                if (debug) console.log(res)
                setState(res)
            })
        })
}

export function useJson<T = any>(url: Url, defaultValue: T | (() => T)): T {
    const [restObj, setObj] = useState<T>()

    useEffect(() => {
        if (!url) return
        if (url == "") return;
        fetchJson<T>(url, setObj, defaultValue)
    }, [url, setObj])

    if (restObj) return restObj

    return defaultValue instanceof Function ? defaultValue() : defaultValue

}
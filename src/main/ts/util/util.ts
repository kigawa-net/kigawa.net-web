import {useEffect, useState} from "react";

export function fetchJson<T = any>(url: string, setState: (state: any) => void, defaultValue: T | (() => T)) {
    if (url == "") return
    fetch(url)
        .then((res: Response) => {
            if (!res.ok) {
                setState(defaultValue instanceof Function ? defaultValue() : defaultValue)
                return;
            }
            res.json().then((res) => {
                setState(res)
            })
        })
}

export function useRest<T = any>(url: string, defaultValue: T | (() => T)): T {
    const [restObj, setObj] = useState<T>()

    useEffect(() => {
        if (!url) return
        if (url == "") return;
        fetchJson<T>(url, setObj, defaultValue)
    }, [url, setObj])

    if (restObj) return restObj

    return defaultValue instanceof Function ? defaultValue() : defaultValue

}

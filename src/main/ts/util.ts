import {useEffect, useState} from "react";

export function fetchJson<T = any>(url: string, setState: (state: any) => void, defaultValue: T | (() => T)) {
    fetch(url)
        .then((res: Response) => res.json())
        .then((res: any) => {
            if (Object.keys(defaultValue) == res) setState(res)
            console.log(res)

            setState(defaultValue instanceof Function ? defaultValue() : defaultValue)
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

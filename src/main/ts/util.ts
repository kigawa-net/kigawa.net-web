import {useEffect, useState} from "react";

export function fetchJson(url: string, setState: (state: any) => void, onErr: (err: any) => void = () => {
}) {
    fetch(url)
        .then((res: Response) => res.json())
        .then((res: any) => {
            setState(res.items)
        }, (err: any) => {
            console.log(err)
            onErr(err)
        })
}

export function useRest<T = any>(url: string, defaultValue: T): T {
    const [restObj, setObj] = useState<T>()
    useEffect(() => {
        if (!url) return
        if (url == "") return
        fetchJson(url, setObj)
    })
    if (restObj) return restObj
    return defaultValue
}

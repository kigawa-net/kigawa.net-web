import {UrlString, UrlTemplate} from "../response/json";

export function mapUrl(urlTemplate: UrlTemplate, key: string, value: string): URL {
    if (urlTemplate == undefined) return null
    return createURL(urlTemplate.replace("{" + key + "}", value))
}

export function createURL(url: URL | UrlString | string) {
    if (url == undefined) return undefined
    if (url == "") return undefined

    try {
        return new URL(url, window.location.href)
    } catch (e) {
        console.error(e)
        return null
    }
}

export function getValue<T>(value: T | (() => T)) {
    return value instanceof Function ? value() : value
}

import {Url} from "../response/json";

export function mapUrl(url: Url, key: string, value: string): Url {
    return url.replace("{" + key + "}", value)
}
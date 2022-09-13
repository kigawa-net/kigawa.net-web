import {initService, Service} from "../response/json";
import {useJson} from "./jsonHook";
import {mapUrl} from "../util/urlUtil";
import {useRootJson} from "./rootJsonHook";

export function getService(name: string): Service {
    const url = mapUrl(useRootJson().service, "name", name)
    return useJson(url, initService)
}
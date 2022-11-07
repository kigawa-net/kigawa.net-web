import {initService, Service} from "../response/json";
import {useJson} from "./jsonHook";
import {mapUrl} from "../util/util";
import {useRootJson} from "./rootJsonHook";

export function useService(strId: string): Service {
    const url = mapUrl(useRootJson().service, "strId", strId)
    return useJson(url, initService)
}
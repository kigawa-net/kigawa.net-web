export type Url = string

export interface Root {
    imageList: Url
    serviceList: Url
    service: Url
}

export function initRoot(): Root {
    return {
        imageList: "",
        serviceList: "",
        service: "",
    }
}

export interface Images {
}

export function initImages(): Images {
    return {}
}

export interface ServiceList {
    serviceMap: Map<string, Service>
}

export function initServiceList(): ServiceList {
    return {
        serviceMap: new Map<string, Service>()
    }
}

export interface Service {
    topImg: string
    title: string
    strId: string
}

export function initService(): Service {
    return {
        topImg: "",
        title: "",
        strId: "",
    }
}
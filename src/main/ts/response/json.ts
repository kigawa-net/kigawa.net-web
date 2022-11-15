export  type UrlTemplate = string
export type UrlString = string

export interface Root {
    imageList: UrlString
    serviceList: UrlString
    service: UrlTemplate
    themeUrl: UrlString
}

export function initRoot(): Root {
    return {
        imageList: "",
        serviceList: "",
        service: "",
        themeUrl: "",
    }
}

export interface Images {
}

export function initImages(): Images {
    return {}
}

export interface ServiceList {
    serviceList: Service[]
}

export function initServiceList(): ServiceList {
    return {
        serviceList: []
    }
}

export interface Service {
    topImg: UrlString
    title: string
    titleColor: string
    strId: string
    description: string
}

export function initService(): Service {
    return {
        topImg: "",
        title: "",
        titleColor: "",
        strId: "",
        description: "",
    }
}

export interface Theme {
    accent: string
    accent2: string
    accent3: string
    base: string
    baseText: string
    reverse: string
    fonts: Font[]
}

export function initTheme(): Theme {
    return {
        accent: "", accent2: "", accent3: "", base: "", baseText: "", fonts: [], reverse: ""
    }
}

export interface Font {
    name: string
    url: UrlString
}

export function initFont(): Font {
    return {
        name: "",
        url: "",
    }
}
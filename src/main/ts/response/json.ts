export interface TopJson {
    topImg: string
}

export function initTopJson(): TopJson {
    return {
        topImg: ""
    }
}

export interface ServicesJson {
    services: ServiceJson[]
}

export function initServiceJson(): ServicesJson {
    return {
        services: []
    }
}

export interface ServiceJson {
    servicePage: string
    serviceRest: string
    name: string
    overview: string
}

export interface RootJson {
    pageUrl: string
}

export function initRootJson(): RootJson {
    return {
        pageUrl: ""
    }
}

export interface Page {
    name: string
    pagePath: string
    pageUrl: string
    restUrl: string
}

export function initPage(): Page {
    return {
        name: "not found",
        pagePath: "/404",
        pageUrl: "/404",
        restUrl: ""
    }
}


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
    sitemap: Page[]
}

export function initRootJson(): RootJson {
    return {
        sitemap: []
    }
}

export interface Page {
    name: string
    pageUrl: string
    restUrl: string
}

export function initPage(): Page {
    return {
        name: "",
        pageUrl: "",
        restUrl: ""
    }
}

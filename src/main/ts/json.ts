
export interface TopJson {
    topImg: string
}

export function getTopJson(): TopJson {
    return {
        topImg: ""
    }
}

export interface ServicesJson {
    services: ServiceJson[]
}

export function getServiceJson(): ServicesJson {
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
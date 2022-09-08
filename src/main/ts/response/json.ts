export interface RootJson {
    imagesUrl: string
    servicesUrl: string
}

export function initRootJson(): RootJson {
    return {
        imagesUrl: "",
        servicesUrl: ""
    }
}

export interface Images {
}

export function initImages(): Images {
    return {}
}

export interface Services {
    serviceMap: Map<string, Service>
}

export function initServices(): Services {
    return {
        serviceMap: new Map<string, Service>()
    }
}

export interface Service {
    topImg: string
}

export function initService(): Service {
    return {
        topImg: ""
    }
}
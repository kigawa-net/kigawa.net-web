export interface RootJson {
    imagesUrl: string
}

export function initRootJson(): RootJson {
    return {
        imagesUrl: ""
    }
}

export interface Images {
    topImg: string
}

export function initImages(): Images {
    return {
        topImg: ""
    }
}
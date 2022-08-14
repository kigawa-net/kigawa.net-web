export interface RootJson {
    homePage: string
    homeRest: string
}

export function getRootJson(): RootJson {
    return {
        homeRest: "",
        homePage: "",
    }
}

export interface TopJson {
    topImg: string
}

export function getTopJson(): TopJson{
    return {
        topImg: ""
    }
}
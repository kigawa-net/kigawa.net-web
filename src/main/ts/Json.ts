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

export interface HomeJson {
    topImg: string
}

export function getHomeJson(): HomeJson{
    return {
        topImg: ""
    }
}
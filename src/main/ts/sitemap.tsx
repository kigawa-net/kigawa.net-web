import React, {Context, useContext, useState} from "react";

export interface Sitemap {

}

export function getSitemap(): Sitemap {
    return {}
}


const SitemapContext: Context<Sitemap> = React.createContext(getSitemap())
let setSitemapFunc: (sitemap: Sitemap) => void = () => {
}

export function SitemapProvider(props: any) {
    const [sitemap, setState] = useState(getSitemap)
    setSitemapFunc = setState

    return <SitemapContext.Provider value={sitemap}>
        {props.children}
    </SitemapContext.Provider>
}

export function setTheme(sitemap: Sitemap) {
    setSitemapFunc(sitemap)
}

export function useSitemap(): Sitemap {
    return useContext(SitemapContext)
}
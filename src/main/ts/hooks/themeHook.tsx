import React, {Context, useContext, useEffect, useState} from "react";
import {initTheme, Root, Theme} from "../response/json";
import {fetchJson} from "./jsonHook";
import {useRootJson} from "./rootJsonHook";

let ThemeContext: Context<Theme> = React.createContext(initTheme())
let setThemeFunc: (theme: Theme) => void = () => {
}

export function ThemeProvider(props: any) {
    const [theme, setState] = useState(initTheme)
    const root = useRootJson()
    setThemeFunc = setState
    useEffect(()=>{
        resetTheme(root)
    },[root])

    const nonNullTheme = theme == undefined ? initTheme() : theme

    return <ThemeContext.Provider value={nonNullTheme}>
        <div style={{color: nonNullTheme.baseText, backgroundColor: nonNullTheme.base}}>
            {props.children}
        </div>
    </ThemeContext.Provider>
}

export function resetTheme(root: Root) {
    fetchJson(root.themeUrl, setThemeFunc, initTheme)
}

export function useTheme(): Theme {
    return useContext(ThemeContext)
}
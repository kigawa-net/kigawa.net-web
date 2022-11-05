import React, {Context, useContext, useState} from "react";

export const themes: ThemeHook[] = [
    {
        bg_accent: " yellowgreen",
        bg_accent_sub: " olivedrab",
        bg: " whitesmoke",
        bg_element: " lightgray",
        text_accent: "darkgreen",
        text_main: "darkgreen",
        text_sub: "gray",
    },
]

const ThemeContext: Context<ThemeHook> = React.createContext(themes[0])
let setThemeFunc: (theme: ThemeHook) => void = () => {
}

export interface ThemeHook {
    bg_accent: string
    bg_accent_sub: string
    bg: string
    bg_element: string
    text_accent: string
    text_main: string
    text_sub: string
}


export function ThemeProvider(props: any) {
    const [theme, setState] = useState(themes[0])
    setThemeFunc = setState

    return <ThemeContext.Provider value={theme}>
        <div style={{color: theme.text_main, backgroundColor: theme.bg}}>
            {props.children}
        </div>
    </ThemeContext.Provider>
}

export function setTheme(theme: ThemeHook) {
    setThemeFunc(theme)
}

export function useTheme(): ThemeHook {
    return useContext(ThemeContext)
}
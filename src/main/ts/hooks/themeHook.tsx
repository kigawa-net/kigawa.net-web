import React, {Context, useContext, useState} from "react";

export const themes: ThemeHook[] = [
    {
        accent: "#c7dc68",
        accent2: "#c3d825",
        accent3: "olivedrab",
        base: "whitesmoke",
        base_text: "darkgreen",
        reverse: "darkgreen",
    },
]

const ThemeContext: Context<ThemeHook> = React.createContext(themes[0])
let setThemeFunc: (theme: ThemeHook) => void = () => {
}

export interface ThemeHook {
    accent: string
    accent2: string
    accent3: string
    base: string
    base_text: string
    reverse: string
}


export function ThemeProvider(props: any) {
    const [theme, setState] = useState(themes[0])
    setThemeFunc = setState

    return <ThemeContext.Provider value={theme}>
        <div style={{color: theme.base_text, backgroundColor: theme.base}}>
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
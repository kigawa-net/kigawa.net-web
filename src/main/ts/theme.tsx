import React, {Context, useContext, useState} from "react";

export const themes: Theme[] = [
    {
        bg_accent: " bg-green-500",
        bg_accent_sub: " bg-green-300",
        bg_back: " bg-gray-100",
        bg_element: " bg-gray-300",
        text_accent: " text-green-900",
        text_main: " text-black",
        text_sub: " text-gray-400",
    },
]

const ThemeContext: Context<Theme> = React.createContext(themes[0])
let setThemeFunc: (theme: Theme) => void = () => {
}

export interface Theme {
    bg_accent: string
    bg_accent_sub: string
    bg_back: string
    bg_element: string
    text_accent: string
    text_main: string
    text_sub: string
}


export function ThemeProvider(props: any) {
    const [theme, setState] = useState(themes[0])
    setThemeFunc = setState

    return <ThemeContext.Provider value={theme}>
        {props.children}
    </ThemeContext.Provider>
}

export function setTheme(theme: Theme) {
    setThemeFunc(theme)
}

export function useTheme(): Theme {
    return useContext(ThemeContext)
}
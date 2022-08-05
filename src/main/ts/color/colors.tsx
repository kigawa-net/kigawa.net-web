import React, {Context, useState} from "react";

const themes: Theme[] = [
    {bg_accent: "bg-green-800"},
]

const ThemeContext: Context<Theme> = React.createContext(themes[0])
let changeTheme: (theme: Theme) => void = () => {
}

type Theme = {
    bg_accent: string
}

type Props = {
    children: any
}

const ThemeProvider = (props: Props) => {
    const [theme, setTheme] = useState(themes[0])
    changeTheme = setTheme

    return <ThemeContext.Provider value={theme}>
        {props.children}
    </ThemeContext.Provider>
}
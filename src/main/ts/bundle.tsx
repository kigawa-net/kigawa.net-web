import React from "react";
import ReactDOM from "react-dom";
import {Header} from "./base/Header";
import {ThemeProvider, useTheme} from "./theme/theme";

export function siteName(): string {
    return "kigawa.net"
}

const Bundle = () => {
    const theme = useTheme()

    return <ThemeProvider>
        <div className={theme.bg_back + " h-full"}>
            <Header/>
        </div>
    </ThemeProvider>
}
ReactDOM.render(<Bundle/>, document.getElementById("react"))

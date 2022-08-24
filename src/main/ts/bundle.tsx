import React from "react";
import ReactDOM from "react-dom";
import {ThemeProvider} from "./hooks/theme";
import {BrowserRouter} from "react-router-dom";
import {Header} from "./component/Header";
import {RootJsonProvider} from "./hooks/rootJson";
import {Contents} from "./component/Contents";

export const siteName = "kigawa.net"

function Bundle() {
    return <BrowserRouter>
        <RootJsonProvider>
            <ThemeProvider>
                <Header/>
                <Contents/>
            </ThemeProvider>
        </RootJsonProvider>
    </BrowserRouter>
}

ReactDOM.render(<Bundle/>, document.getElementById("react"))

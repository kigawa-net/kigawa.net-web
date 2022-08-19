import React from "react";
import ReactDOM from "react-dom";
import {ThemeProvider, useTheme} from "./hooks/theme";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Top} from "./component/service/Top";
import {Header} from "./component/Header";
import {getPageJson, RootJsonProvider} from "./hooks/rootJson";
import {Service} from "./component/service/service";
import {Contents} from "./component/Contents";

export const siteName = "kigawa.net"

function Bundle() {
    return <BrowserRouter>
        <RootJsonProvider>
            <ThemeProvider>
                <div className={useTheme().text_main}>
                    <Header/>
                    <Contents/>
                </div>
            </ThemeProvider>
        </RootJsonProvider>
    </BrowserRouter>
}

ReactDOM.render(<Bundle/>, document.getElementById("react"))

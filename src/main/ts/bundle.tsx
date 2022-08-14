import React from "react";
import ReactDOM from "react-dom";
import {ThemeProvider, useTheme} from "./theme";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Top} from "./component/service/Top";
import {Header} from "./component/Header";
import {RootJsonProvider} from "./response/rootJson";

export const siteName = "kigawa.net"

function Bundle() {
    return <BrowserRouter>
        <RootJsonProvider>
            <ThemeProvider>
                <div className={useTheme().text_main}>
                    <Header/>
                    <Routes>
                        <Route path={"/*"} element={<Top/>}/>
                    </Routes>
                </div>
            </ThemeProvider>
        </RootJsonProvider>
    </BrowserRouter>
}

ReactDOM.render(<Bundle/>, document.getElementById("react"))

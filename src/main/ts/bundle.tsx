import React from "react";
import ReactDOM from "react-dom";
import {ThemeProvider, useTheme} from "./theme/theme";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Top} from "./component/Top";
import {useRest} from "./util";
import {Header} from "./component/Header";
import {getRootJson, RootJson} from "./Json";

export const siteName = "kigawa.net"

function Bundle() {
    const rootJson: RootJson = useRest(
        document.getElementById("baseurl").innerText,
        getRootJson,
    )

    return <BrowserRouter>
        <ThemeProvider>
            <div className={useTheme().text_main}>
                <Header rootJson={rootJson}/>
                <Routes>
                    <Route path={"/*"} element={<Top rootJson={rootJson}/>}/>
                </Routes>
            </div>
        </ThemeProvider>
    </BrowserRouter>
}

ReactDOM.render(<Bundle/>, document.getElementById("react"))

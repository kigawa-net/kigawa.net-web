import React from "react";
import ReactDOM from "react-dom";
import {ThemeProvider} from "./theme/theme";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Home} from "./component/Home";
import {useRest} from "./util";
import {Header} from "./component/Header";
import {getRootJson, RootJson} from "./Json";

export const siteName = "kigawa.net"

function Bundle() {
    const rootJson: RootJson = useRest(
        document.getElementById("baseurl").innerText,
        getRootJson(),
    )

    return <BrowserRouter>
        <ThemeProvider>
            <Header rootJson={rootJson}/>
            <Routes>
                <Route path={"/*"} element={<Home rootJson={rootJson}/>}/>
            </Routes>
        </ThemeProvider>
    </BrowserRouter>
}

ReactDOM.render(<Bundle/>, document.getElementById("react"))

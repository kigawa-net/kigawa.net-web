import React, {useEffect, useState} from "react";
import ReactDOM from "react-dom";
import {ThemeProvider} from "./theme/theme";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {Home} from "./component/Home";
import {fetchJson} from "./util/util";
import {Header} from "./component/Header";

export const siteName = "kigawa.net"

export interface RootJson {
    homeUrl: string
}

function Bundle() {
    const [rootJson, setRootJson] = useState<RootJson>(undefined)

    useEffect(() => {
        fetchRootJson(setRootJson)
    })

    return <BrowserRouter>
        <ThemeProvider>
            <Header rootJson={rootJson}/>
            <Routes>
                <Route path={"/*"} element={<Home rootJson={rootJson}/>}/>
            </Routes>
        </ThemeProvider>
    </BrowserRouter>
}

function fetchRootJson(setState: (state: any) => void) {
    const url = document.getElementById("baseurl").innerText
    fetchJson(url, setState)
}

ReactDOM.render(<Bundle/>, document.getElementById("react"))

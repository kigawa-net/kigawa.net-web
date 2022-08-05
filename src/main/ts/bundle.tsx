import React from "react";
import ReactDOM from "react-dom";
import {Header} from "./base/Header";

const Bundle = () => {
    return <div className={""}>
        <Header/>

    </div>
}

ReactDOM.render(<Bundle/>, document.getElementById("react"))
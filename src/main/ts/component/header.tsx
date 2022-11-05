import React from "react";
import {useTheme} from "../hooks/themeHook";
import {Logo} from "./logo";
import {Link} from "react-router-dom";
import {Pages} from "./contents";
import {ButtonFrame} from "./util/elements";

interface Prop {
}

export function Header(props: Prop) {
    const theme = useTheme()

    return <div className={"pt-1 bg-opacity-70 h-10 flex text-center"}
                style={{backgroundColor: theme.accent}}>
        <div className={"mr-16"}>
            <Logo/>
        </div>

        <Link to={Pages.service}>
            <ButtonFrame inClass={"w-32 text-lg"} removePadding>
                <p>services</p>
            </ButtonFrame>
        </Link>
    </div>
}

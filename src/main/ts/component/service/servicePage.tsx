import {Service} from "./service";
import React from "react";

interface Props {
    match?: {
        params: {
            id: string
        }
    }
}

export function ServicePage(props: Props) {
    return <Service strId={props.match.params.id}/>
}
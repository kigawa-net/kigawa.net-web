import {useTheme} from "../../hooks/themeHook";
import React, {CSSProperties} from "react";

interface Props {
    inStyle?: CSSProperties | undefined
    inClass?: string | undefined
    outStyle?: CSSProperties | undefined
    outClass?: string | undefined
    backColor?: string
    frameColor?: string
    children: any
    removePadding?: boolean
}

export function BlockFrame(props: Props) {
    const theme = useTheme()

    let backColor = props.backColor
    if (backColor == undefined) {
        backColor = theme.accent
    }

    let frameColor = props.frameColor
    if (backColor == undefined) {
        backColor = theme.accent3
    }

    let parentStyle = props.outStyle
    if (parentStyle == undefined) {
        parentStyle = {}
    }
    parentStyle.backgroundColor = backColor

    let style = props.inStyle
    if (style == undefined) {
        style = {}
    }
    style.borderColor = frameColor

    let inClass = props.inClass
    if (inClass == undefined) {
        inClass = ""
    }
    let outClass = props.outClass
    if (outClass == undefined) {
        outClass = ""
    }

    if (!props.removePadding) {
        outClass = outClass + " p-1"
    }

    return <div className={"w-min " + outClass} style={parentStyle}>
        <div className={"border-2 " + inClass}
             style={style}>
            {props.children}
        </div>
    </div>
}

export function ButtonFrame(props: Props) {
    const newProps: Props = {
        backColor: props.backColor,
        children: props.children,
        frameColor: props.frameColor,
        inClass: props.inClass,
        inStyle: props.inStyle,
        outClass: props.outClass + " hover:drop-shadow-lg",
        outStyle: props.outStyle,
        removePadding: props.removePadding
    }
    return BlockFrame(newProps)
}
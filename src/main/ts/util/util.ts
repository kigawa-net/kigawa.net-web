
export function fetchJson(url: string, setState: (state: any) => void, onErr: (err: any) => void = () => {
}) {
    fetch(url)
        .then((res: Response) => res.json())
        .then((res: any) => {
            setState(res.items)
        }, (err: any) => {
            console.log(err)
            onErr(err)
        })
}

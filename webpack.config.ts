import path from "path";

module.exports = {
    // 入力ファイル設定
    entry: './src/main/ts/app.tsx',
    devtool: 'source-map',
    mode: 'development',
    cache: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },

    // モジュール設定
    module: {
        rules: [
            {
                // ts-loaderの設定
                test: /\.(ts|tsx)?$/,
                use: "ts-loader",
                exclude: /node_modules/
            },
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            },
        ]
    },
    // モジュール解決
    resolve: {
        extensions: [".ts", ".tsx", ".js", ".json"]
    },
};

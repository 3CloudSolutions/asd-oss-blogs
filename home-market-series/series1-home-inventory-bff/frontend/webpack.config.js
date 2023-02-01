var path = require("path")
const HtmlWebpackPlugin = require('html-webpack-plugin')

const PATHS = {
    build: path.join(
        __dirname,
        "..",
        "src",
        "main",
        "resources",
        "static"
    )
}

module.exports = {
    entry: path.join(__dirname, "src", "index.js"),
    mode: "development",
    output: {
        path: PATHS.build,
        filename: "index.js",
        clean: true
    },
    resolve: {
        extensions: ["*", ".js", ".jsx", ".ts", ".tsx", ".json", ".css", ".scss"],
        modules: [path.resolve(__dirname, "src"), "node_modules"]
    },
    module: {
        rules: [
            {
                test: /\.m?js$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader",
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.(jpg|jpeg|png|gif|mp3|svg)$/,
                type: "asset/resource"
            }
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({
            title:
                "Test",
            template: path.join(__dirname, "src", "index.html")
        }),
    ]
}

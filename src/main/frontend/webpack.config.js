const path = require("path");

module.exports = {
  mode: "development",
  entry: ["./src/index.js"],
  output: {
    path: path.join(__dirname, "../resources/META-INF/resources"),
    publicPath: "/",
    filename: "bundle.js"
  },
  module: {
    rules: [
      {
        test: /\.m?js$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: ["@babel/preset-env", "@babel/preset-react"],
            plugins: ["@babel/plugin-proposal-class-properties"]
          }
        }
      }
    ]
  },
  devtool:'source-map'
};

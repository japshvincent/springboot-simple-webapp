const path = require('path');

const PATHS = {
    build: path.join(__dirname, 'static', 'js')
};

module.exports = {
    entry: {
        module1: './src/js/module1.js',
        module2: './src/js/module2.js',
        module3: './src/js/module3.js',
        appBaseJs: './src/js/someSimpleAppBase.js',
        appBaseCss: './src/scss/someSimpleAppBase.scss'
    },
    output: {
        path: PATHS.build,
        filename: '[name].min.js'
    },
    module: {
        rules: [
            {
                test: /\.(scss)$/,
                use: [
                    {
                        // Adds CSS to the DOM by injecting a `<style>` tag
                        loader: 'style-loader'
                    },
                    {
                        // Interprets `@import` and `url()` like `import/require()` and will resolve them
                        loader: 'css-loader'
                    },
                    {
                        // Loader for webpack to process CSS with PostCSS
                        loader: 'postcss-loader',
                        options: {
                            plugins: function () {
                                return [
                                    require('autoprefixer')
                                ];
                            }
                        }
                    },
                    {
                        // Loads a SASS/SCSS file and compiles it to CSS
                        loader: 'sass-loader'
                    }
                ]
            }
        ]
    }
};
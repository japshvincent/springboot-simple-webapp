const webpackConfig = require("./webpack.config.js");
const sass = require('node-sass');
module.exports = function(grunt) {
    grunt.initConfig({
        webpack: {
            options: {
                stats: !process.env.NODE_ENV || process.env.NODE_ENV === 'development'
            },
            prod: webpackConfig,
            dev: Object.assign({ watch: false }, webpackConfig)
        },
        sass: {
            dist: {
                options: {
                    implementation: sass,
                    sourceMap: true,
                    style: 'expanded'
                },
                files: {
                    './static/css/bootstrap.css':'./src/scss/bootstrap.scss'
                }
            }
        }
    });
    grunt.loadNpmTasks('grunt-webpack');
    grunt.loadNpmTasks('grunt-sass');
    grunt.registerTask('default', ['webpack', 'sass']);
};
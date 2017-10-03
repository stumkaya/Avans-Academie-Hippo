'use strict';

module.exports = function() {
    var root = './';
    var src = root +'src/';
    var dist = root +'dist/';
    var temp = root + '.tmp/';

    var npm = {
        json: require('./package.json'),
        directory: './node_modules/'
    };

    var config = {
        // file paths
        dist: dist,
        src: src,
        html: {
            src: [src + '**/*.html', '!' + src + '**/_*.html'],
            dest: dist
        },
        includes: {
            src: [src + '**/_*.html']
        },
        scss: {
            src: [src + 'scss/**/*.scss'],
            dest: dist + 'css/'
        },
        images: {
            src: [src+ 'images/**/*.*', '!' + src + 'images/**/*.psd'],
            dest: dist + 'images/'
        },
        photos: {
            src: [src+ 'photos/**/*.*', '!' + src + 'photos/**/*.psd'],
            dest: dist + 'photos/'
        },
        favicon: {
            src: [src + 'favicon/**/*.*'],
            dest: dist + 'favicon/'
        },
        fonts: {
            src: [src + 'fonts/**/*.*',
                npm.directory + 'font-awesome/fonts/**/*.*'],
            dest: dist + 'fonts/'
        },
        javascript: {
            src: [src + 'scripts/**/*.js'],
            dest: dist + 'scripts/',
            uglify: false
        },
        vendor: {
            src: [npm.directory + 'jquery/dist/jquery.min.js',
                npm.directory + 'bootstrap-sass/assets/javascripts/bootstrap.min.js',
                src + 'vendor/**/*.js'],
            dest: dist + 'scripts/vendor/'
        },

        //file include
        fileInclude: {
            prefix: '@@',
            basepath: '@file'
        },

        // browser sync
        browserSync: {
            logPrefix: 'browser-sync',
            browser: 'Chrome',
            open: true,
            startPath: '/index.html',
            server: {
                baseDir: dist
            }
        },

        //package manager
        npm: npm,
        packages: [
            './package.json'
        ]
    }

    return config;
}
'use strict';

var browserSync = require('browser-sync');
var gulp = require('gulp');
var config = require('./gulp.config')();
var del = require('del');

var $ = require('gulp-load-plugins')({lazy: true});

var autoprefixer = require('autoprefixer');
var postcssSorting = require('postcss-sorting');
var cssnano = require('cssnano');

var processors = [
    autoprefixer(['last 3 versions']),
    postcssSorting(),
    cssnano()
];

gulp.task('clean', function () {
    return del(config.dist + '/**/*');
});

gulp.task('html', function () {
    return gulp.src(config.html.src)
        .pipe($.fileInclude(config.fileInclude))
        .pipe(gulp.dest(config.html.dest))
        .pipe(browserSync.reload({ stream: true }));
});

gulp.task('images', function () {
    return gulp.src(config.images.src)
        .pipe(gulp.dest(config.images.dest));
});

gulp.task('photos', function () {
    return gulp.src(config.photos.src)
        .pipe(gulp.dest(config.photos.dest));
});

gulp.task('favicon', function () {
    return gulp.src(config.favicon.src)
        .pipe(gulp.dest(config.favicon.dest));
});

gulp.task('fonts', function () {
    return gulp.src(config.fonts.src)
        .pipe(gulp.dest(config.fonts.dest));
});

gulp.task('scss', function() {
    return gulp.src(config.scss.src)
        .pipe($.sourcemaps.init())
        .pipe($.sass({
            includePaths: config.scss.src,
            errLogToConsole: true
        }).on('error', $.sass.logError))
        .pipe($.postcss(processors))
        .pipe($.concat('styles.min.css'))
        .pipe($.sourcemaps.write('./maps'))
        .pipe(gulp.dest(config.scss.dest))
        .pipe($.filter('**/*.css'))
        .pipe(browserSync.reload({ stream: true }));
});

gulp.task('javascript', function () {
    var result = gulp.src(config.javascript.src)
        .pipe($.concat('scripts.min.js'));
    if (config.javascript.uglify) {
        result.pipe($.uglify());
    }
    return result.pipe(gulp.dest(config.javascript.dest))
    .pipe(browserSync.reload({ stream: true }));
});

gulp.task('vendor', function () {
    return gulp.src(config.vendor.src)
        .pipe(gulp.dest(config.vendor.dest));
});

gulp.task('help', function () {
        console.log([
            '',
            'Usage: gulp <taskname>',
            '',
            'Available tasks:',
            '',
            '   build       : Build and copy all required files to \'dist\' folder',
            '   serve       : Serve and open \'index.html\' using browserSync and update ',
            '                 files in the \'dist\' folder when they change.',
            '   start       : Perform build and serve sequentially.',
            '',
            'e.g. gulp build',
            ''
        ].join('\n'));
});
gulp.task('default', ['help']);

gulp.task('build', $.sequence(
            'clean',
            [
                'html',
                'javascript',
                'images',
                'photos',
                'favicon',
                'fonts',
                'vendor',
                'scss'
            ]));

gulp.task('serve', function(){
    browserSync(config.browserSync);

    gulp.watch([config.javascript.src], ['javascript']);
    gulp.watch([config.scss.src], ['scss']);
    gulp.watch([config.images.src], ['images']);
    gulp.watch([config.photos.src], ['photos']);
    gulp.watch([config.html.src], ['html']);
    gulp.watch([config.includes.src], ['html']);
});

gulp.task('start', 
    $.sequence('build', 'serve')
);
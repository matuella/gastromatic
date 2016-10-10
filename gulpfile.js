'use strict';

var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var minify = require('gulp-minify-css');
var source = require('vinyl-source-stream');
var browserify = require('browserify');

const jsPath = "./src/main/webapp/resources/scripts/**/*.js";
const cssPath = "./src/main/webapp/resources/css/**/*.css";

const npmJsDeps = [ 
   './node_modules/jquery/dist/jquery.min.js', 
   './node_modules/foundation-sites/dist/foundation.min.js',
   './node_modules/angular/angular.min.js', 
   './node_modules/angular-resource/angular-resource.min.js',
   './node_modules/angular-route/angular-route.min.js'
];

const outputPath = "./src/main/webapp/dist";

gulp.task('browserify', function() {
    return browserify({ entries: ['./src/main/webapp/resources/scripts/app.js'] })
        .bundle()
        .pipe(source('scripts.js'))
        .pipe(gulp.dest(outputPath + '/js'));
});

//gulp.task('js', function() {
//	gulp.src(jsPath)
//	.pipe(concat('scripts.js'))
//	.pipe(uglify())
//	.pipe(gulp.dest(outputPath));
//});

//gulp.task('watch', function() {
//	gulp.watch(jsPath, [ 'js' ]);
//});

gulp.task('default', [ 'browserify']);
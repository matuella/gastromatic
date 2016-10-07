'use strict';

var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var minify = require('gulp-minify-css');

const jsPath = "./src/main/webapp/resources/scripts/**/*.js";
const cssPath = "./src/main/webapp/resources/css/**/*.css";

const npmJsDeps = [ 
   './node_modules/jquery/dist/jquery.min.js', 
   './node_modules/foundation-sites/dist/foundation.min.js',
   './node_modules/angular/angular.min.js', 
   './node_modules/angular-resource/angular-resource.min.js',
   './node_modules/angular-route/angular-route.min.js'
];
const npmCssDeps = [ 
   './node_modules/foundation-sites/dist/foundation.min.css'
];

const outputPath = "./src/main/webapp/resources/dist";

gulp.task('js-deps', function() {
	gulp.src(npmJsDeps)
	.pipe(concat('js-dependencies.js'))
//	.pipe(uglify())
	.pipe(gulp.dest(outputPath));
});

/*
gulp.task('css-deps', function() {
	gulp.src(npmCssDeps)
	.pipe(concat('css-dependencies.css'))
	.pipe(minify())
	.pipe(gulp.dest(outputPath));
});
*/

gulp.task('js', function() {
	gulp.src(jsPath)
	.pipe(concat('scripts.js'))
	.pipe(uglify())
	.pipe(gulp.dest(outputPath));
});

/*
gulp.task('css', function() {
	gulp.src(cssPath)
	.pipe(concat('styles.css'))
	.pipe(minify())
	.pipe(gulp.dest(outputPath));
});
*/

gulp.task('watch', function() {
	/*gulp.watch(cssPath, [ 'css' ]);*/
	gulp.watch(jsPath, [ 'js' ]);
});

gulp.task('default', [ 'watch', 'js-deps', 'js']);
'use strict';

var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var minify = require('gulp-minify-css');

gulp.task('js', function(){
   gulp.src('./src/main/webapp/resources/scripts/**/*.js')
   .pipe(concat('scripts.js'))
   .pipe(uglify())
   .pipe(gulp.dest('./src/main/webapp/resources/dist'));
});

gulp.task('css', function(){
   gulp.src('./src/main/webapp/resources/css/**/*.css')
   .pipe(concat('styles.css'))
   .pipe(minify())
   .pipe(gulp.dest('./src/main/webapp/resources/dist'));
});

gulp.task('watch', function() {
  gulp.watch('./src/main/webapp/resources/css/**/*.css', ['css']);
  gulp.watch('./src/main/webapp/resources/scripts/**/*.js', ['js']);
});

gulp.task('default', ['watch', 'js', 'css']);
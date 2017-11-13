var 	gulp           = require('gulp'),
		gutil          = require('gulp-util' ),
		sass           = require('gulp-sass'),
		browserSync    = require('browser-sync'),
		concat         = require('gulp-concat'),
		uglify         = require('gulp-uglify'),
		cleanCSS       = require('gulp-clean-css'),
		rename         = require('gulp-rename'),
		del            = require('del'),
		imagemin       = require('gulp-imagemin'),
		cache          = require('gulp-cache'),
		autoprefixer   = require('gulp-autoprefixer'),
		bourbon        = require('node-bourbon'),
		ftp            = require('vinyl-ftp'),
		notify         = require("gulp-notify");
		connectPHP 	   = require('gulp-connect-php');



 

 
gulp.task('default', ['connect']);


// Скрипты проекта
gulp.task('scripts', function() {
	return gulp.src([
		'app/libs/jquery/dist/jquery.min.js',
		'app/libs/slick-carousel/slick/slick.min.js',
		'app/libs/jquery-validation/dist/jquery.validate.min.js',
		'app/libs/jquery.steps/build/jquery.steps.min.js',
		'app/libs/magnific-popup/dist/jquery.magnific-popup.min.js',
		'app/libs/sweetalert2/dist/sweetalert2.min.js',
		'app/libs/jquery.maskedinput/dist/jquery.maskedinput.min.js',
		'app/libs/jquery.scrollTo.min.js',
		'app/js/common.js', // Всегда в конце
		])
	.pipe(concat('scripts.min.js'))
	.pipe(uglify())
	.pipe(gulp.dest('app/js'))
	.pipe(browserSync.reload({stream: true}));
});

gulp.task('browser-sync', function() {
	browserSync({
		proxy: "localhost/acrylicbox",
		notify: false,
		// tunnel: true,
		// tunnel: "projectmane", //Demonstration page: http://projectmane.localtunnel.me
	});
});

// gulp.task('connect-sync', function() {
//   connect.server({ base: 'build', port: 8010, keepalive: true}, function (){
//     browserSync({
// 		server: {
// 			baseDir: 'app'
// 		},
// 		notify: false,
// 		// tunnel: true,
// 		// tunnel: "projectmane", //Demonstration page: http://projectmane.localtunnel.me
//     });
// 	});
// });
gulp.task('sass', function() {
	return gulp.src('app/sass/**/*.sass')
	.pipe(sass({
		includePaths: bourbon.includePaths
	}).on("error", notify.onError()))
	.pipe(rename({suffix: '.min', prefix : ''}))
	.pipe(autoprefixer(['last 15 versions']))
	.pipe(cleanCSS())
	.pipe(gulp.dest('app/css'))
	.pipe(browserSync.reload({stream: true}));
});

gulp.task('watch', ['sass', 'scripts', 'browser-sync'], function() {
	gulp.watch('app/sass/**/*.sass', ['sass']);
	gulp.watch(['libs/**/*.js', 'app/js/common.js'], ['scripts']);
	gulp.watch('app/*.html', browserSync.reload);
	gulp.watch('app/**/*.php', browserSync.reload);
});

gulp.task('imagemin', function() {
	return gulp.src('app/img/**/*')
	.pipe(imagemin())
	.pipe(gulp.dest('dist/img')); 
});

gulp.task('build', ['removedist', 'imagemin', 'sass', 'scripts'], function() {

	var buildFiles = gulp.src([
		'app/*.html',
		'app/**/*.php',
		'app/.htaccess',
		]).pipe(gulp.dest('dist'));

	var buildCss = gulp.src([
		'app/css/main.min.css',
		]).pipe(gulp.dest('dist/css'));

	var buildJs = gulp.src([
		'app/js/scripts.min.js',
		]).pipe(gulp.dest('dist/js'));

	var buildFonts = gulp.src([
		'app/fonts/**/*',
		]).pipe(gulp.dest('dist/fonts'));

});
gulp.task('connect', function() {
  connectPHP.server({
    hostname: '0.0.0.0',
    bin: 'C:/php/php.exe',
    ini: 'C:/php/php.ini',
    port: 8000,
    base: 'dev',
    livereload: true
  });
});
/*gulp.task('deploy', function() {

	var conn = ftp.create({
		host:      'shared-17.smartape.ru',
		user:      'user41663',
		password:  'Ihp8s7AQ',
		parallel:  3,
		log: gutil.log
	});

	var globs = [
	'dist/**',
	'dist/.htaccess',
	];
	return gulp.src(globs, {buffer: false})
	.pipe(conn.dest('/www/acrylicbox.ru'));

});*/

gulp.task('removedist', function() { return del.sync('dist'); });
gulp.task('clearcache', function () { return cache.clearAll(); });

gulp.task('default', ['connect', 'watch']);

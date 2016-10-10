var angular = require('angular');
require('angular-route');
require('angular-resource');

var app = angular.module('gastromaticApp', [ 'ngRoute', 'ngResource' ]);

require('./service');
require('./controller');

app.config(function($routeProvider) {

  $routeProvider.when('/curso', {
    templateUrl: 'views/curso.html',
    controller: 'CursoController',
  })
  .otherwise({
    redirectTo: '/curso',
  });
});
var angular = require('angular');
require('angular-route');

var app = angular.module('gastromaticApp', [ 'ngRoute' ]);

require('./service');
require('./controller');

app.config(function($routeProvider) {

  $routeProvider.when('/cursos', {
    templateUrl: 'views/cursos.html',
    controller: 'CursoController',
  })
  .otherwise({
    redirectTo: '/cursos',
  });
});
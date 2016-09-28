var services = angular.module('gastromaticApp.services', ['ngResource']);

services.factory('CursoFactory', function ($resource) {
	
	var baseUrl = 'http://localhost:8080/gastromatic/';
	
    return $resource(baseUrl + 'cursos/', {}, {
        get: { method: 'GET'},
        query: { method: 'GET', isArray: true },
        create: {method: 'POST'},
        edit: {method: 'PUT'},
        delete: {method: 'DELETE'}
    });
});
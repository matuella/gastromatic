var app = angular.module('gastromaticApp.controllers', []);

app.controller('CursoController', [ '$scope', 'CursoFactory',
		function($scope, CursoFactory) {

			$scope.cursos = CursoFactory.query();

			$scope.addCurso = function(curso) {
				CursoFactory.create(curso);
				curso = null;
			};
		}
]);
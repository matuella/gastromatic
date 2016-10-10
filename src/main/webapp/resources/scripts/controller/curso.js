'use strict';

module.exports = function($scope, CursoService) {

	$scope.cursos = CursoService.query();

	$scope.addCurso = function(curso) {
		CursoService.create(curso);
		curso = null;
	};
}
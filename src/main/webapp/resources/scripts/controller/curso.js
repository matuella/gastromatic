module.exports = function($scope, CursoFactory) {

	$scope.cursos = CursoFactory.query();

	$scope.addCurso = function(curso) {
		CursoFactory.create(curso);
		curso = null;
	};
}
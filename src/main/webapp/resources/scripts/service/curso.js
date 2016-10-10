'use strict';

module.exports = function(){
	
	var baseUrl = 'http://localhost:8080/gastromatic/';
	
    return $resource(baseUrl + 'curso/', {}, {
        get: { method: 'GET'},
        query: { method: 'GET', isArray: true },
        create: {method: 'POST'},
        edit: {method: 'PUT'},
        delete: {method: 'DELETE'}
    });
}

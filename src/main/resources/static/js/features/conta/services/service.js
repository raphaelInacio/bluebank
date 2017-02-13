(function() {
	'use strict';

	angular.module('app').service('ContaService', ContaService);

	ContaService.$inject = [ '$http' ];

	function ContaService($http) {
		var service = {
			listar : listar,
			acessarConta : acessarConta
		};

		return service;

		function listar() {
			return $http({
				method : 'GET',
				url : '/api/contas'
			});
		}

		function acessarConta(numero, cpf) {
			return $http({
				method : 'GET',
				url : 'api/contas/4000/32687308846'
			});
		}

	}

})();
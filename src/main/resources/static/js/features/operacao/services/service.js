(function() {
	'use strict';

	angular.module('app').service('OperacaoService', OperacaoService);

	OperacaoService.$inject = [ '$http' ];

	function OperacaoService($http) {
		var service = {
			listar : listar,
			obterOperacaoPorConta : obterOperacaoPorConta
		};

		return service;

		function listar() {
			return $http({
				method : 'GET',
				url : '/api/listar'
			});
		}

		function obterOperacaoPorConta(numero) {
			return $http({
				method : 'GET',
				url : '/api/operacoes/' + numero 
			});
		}

	}

})();
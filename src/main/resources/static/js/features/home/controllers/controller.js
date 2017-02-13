(function() {
	'use strict';

	angular.module('app').controller('HomeController', HomeController);

	HomeController.$inject = [ 'ContaService', 'OperacaoService' ];

	function HomeController(ContaService, OperacaoService) {
		var vm = this;
		var cpf = '32687308846'
		var numero = 4000; 

		vm.acessarConta = function acessarConta(numero, cpf) {
			ContaService.acessarConta(numero, cpf).then(function(res) {
				vm.conta = res.data;
			});
		}
		
		vm.obterOperacaoPorConta = function obterOperacaoPorConta(numero, cpf) {
			OperacaoService.obterOperacaoPorConta(numero, cpf).then(function(res) {
				vm.operacoes = res.data;
			});
		}

		function init() {
			vm.acessarConta(numero, cpf);
			vm.obterOperacaoPorConta(numero, cpf)
		}

		init();
	}

})();
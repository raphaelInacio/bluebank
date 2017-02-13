(function() {
  'use strict';

  angular.module('app')
    .controller('navBarController', navBarController);

  navBarController.$inject = ['$state'];

  function navBarController($state) {
      var vm = this;
  }

})();
(function() {
  'use strict';

  angular.module('vendors', [
    'ui.bootstrap',
    'ui.router'
  ]);

  angular.module('app', ['vendors']);
  
})();
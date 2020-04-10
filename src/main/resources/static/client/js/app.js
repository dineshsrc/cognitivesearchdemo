(function () {
  'use strict';

  angular.module('cscApp', ['ui.sortable', 'ui.select2', 'ngRoute', 'ui.router', 'ui.bootstrap', 'ngFileSaver'])

    .config(['$routeProvider', '$httpProvider', '$stateProvider', function ($routeProvider, $httpProvider, $stateProvider) {
    	    	    	
      $routeProvider
        .when('/main', {
          controller: 'mainCtrl',
          templateUrl: 'client/views/main.html'
        })        
        .otherwise({
          redirectTo: '/main'
        });
            
      if (!$httpProvider.defaults.headers.get) {
          $httpProvider.defaults.headers.common = {};
      }

      $httpProvider.defaults.headers.common['If-Modified-Since'] = '0';
      $httpProvider.defaults.headers.common['Cache-Control'] = 'no-cache';
      $httpProvider.defaults.headers.common.Pragma = 'no-cache';
      
    }]);
})();

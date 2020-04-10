(function() {
	'use strict';

	angular.module('cscApp').service('cognitiveSvc',
			[ '$q', '$http', 'loader', function($q, $http, loader) {

				var serviceUrl = 'api/search/';
				var errorResp = "Service unavailable";

				this.searchQuery = searchQuery;

				function searchQuery(searchText) {
					var defered = $q.defer();

					var data = {
						url : serviceUrl + 'query?text=' + searchText,
						method : 'GET',
						headers : {
							'Content-Type' : 'application/json'
						}
					};

					var data = {
						text : searchText
					};

					var config = {
						params : data,
						headers : { "Content-Type": "application/json"}
					};
					loader.addService('Cognitive Search is in progress');
					$http.get(serviceUrl + '/query', config).then(function(response) {
						defered.resolve(response.data);
						loader.removeService();
					}, function(response) {
						defered.reject(errorResp);
						loader.removeService();
					});
					return defered.promise;
				}

			} ]);

}());

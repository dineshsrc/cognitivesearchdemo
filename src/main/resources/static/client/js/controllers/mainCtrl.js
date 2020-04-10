(function () {
    'use strict';

    angular.module('cscApp')
        .controller('mainCtrl', ['$scope', 'cognitiveSvc', 'FileSaver', function ($scope, cognitiveSvc, FileSaver) {
           
        	 	$scope.result = undefined;
        	 	$scope.error = '';
        	 	$scope.searchText;

        	 	$scope.submit = function() {
        	 	    if ($scope.searchText && $scope.searchText.length > 0) {
        	 	    	 $scope.error = '';
		                 cognitiveSvc.searchQuery($scope.searchText).then(function(data) {
		                	 $scope.result = data;
		                 }, function (error) {
		                	 console.log(error);
		                 });        	 	            	 	  
        	 	    } else {
        	 	    	$scope.error = 'Please provide any string';
        	 	    	$scope.result = [];
        	 	    }
        	 	};
        	 	
        	 	$scope.download = function(text, name, contentType) {        	 		 
        	 		 var file = new Blob([text], {type: contentType});
        	 		 FileSaver.saveAs(file, name);
        	 	};
        }]);

}());

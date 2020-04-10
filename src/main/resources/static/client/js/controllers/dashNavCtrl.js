(function () {
    'use strict';
    angular.module('cscApp').controller('dashNavCtrl', ['$scope', '$log', function ($scope, $log) {
        $scope.$log = $log;
        $scope.$log.log('dashNavCtrl - creation');
        $scope.errorCount = 0;
    }]);
}());

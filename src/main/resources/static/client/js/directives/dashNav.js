(function () {
    'use strict';
    angular.module('cscApp').directive('dashNav', function () {
        return {
            restrict: 'A',
            templateUrl: 'client/views/dashNav.html',
            controller: "dashNavCtrl",
            replace: true
        };
    });
}());

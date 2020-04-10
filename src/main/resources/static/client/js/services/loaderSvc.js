(function () {
    'use strict';
    angular.module('cscApp').service("loader", ['$rootScope', function ($rootScope) {

        var vm = this;

        this.ongoingServiceCount = 0;
        $rootScope.webServiceConfig = {};

        this.addService = addService;
        this.removeService = removeService;

        function addService(message) {
            vm.ongoingServiceCount += 1;
            message = message || 'Loading...';
            checkAndShowPopup(message);
        }

        function removeService() {
            vm.ongoingServiceCount -= 1;
            checkAndRemovePopup();
        }

        function checkAndShowPopup(message) {
            $rootScope.webServiceConfig.showServicePopup = true;
            $rootScope.webServiceConfig.serviceMessage = message;
        }

        function checkAndRemovePopup() {
            if (vm.ongoingServiceCount <= 0) {
                $rootScope.webServiceConfig.showServicePopup = false;
                $rootScope.webServiceConfig.serviceMessage = "";
                vm.ongoingServiceCount = 0;
            }
        }
    }]);

}());

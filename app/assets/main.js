angular.module('myApp', []).
    controller('Hello', function($scope, $http, $timeout) {
        $scope.msg = "";

        $scope.sendName = function() {
            $http({method: 'GET', url: '/tweets', params: {q: $scope.yourName}}).
                        success(function(data) {
                            $scope.tweets = data;
                        });
                  };


    });
'use strict';

angular.module('yoApp').controller('userCtrl', function($scope, $http) {
	
	$http.get('http://localhost:8080/TAA/rest/user').success(function(data) {
		$scope.users = data;
	}).error(function(data,status)
	{
		$scope.error=data;
		$scope.status=status;
	});
});


'use strict';

angular.module('yoApp').controller('seanceCtrl', function($scope, $http) {
	
	$http.get('http://localhost:8080/TAA/rest/seance').success(function(data) {
		$scope.seances = data;
	}).error(function(data,status)
	{
		$scope.error=data;
		$scope.status=status;
	});
	
});


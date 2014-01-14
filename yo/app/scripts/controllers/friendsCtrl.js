'use strict';

angular.module('yoApp').controller('friendsCtrl', function($scope, $resource) {

	var User = $resource('/TAA/rest/user/:userid',{userid:'1'});
	$scope.user = User.$query;

});


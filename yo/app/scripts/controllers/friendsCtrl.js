'use strict';

angular.module('yoApp').controller('friendsCtrl', function($scope, $resource) {

	var User = $resource('/TAA/rest/user/:userid',{userid:'@id'});
	$scope.user = User.get({userid:1}, function(){
		$scope.friendlist = $scope.user.amis;
	});
	$scope.userlist = User.$query;
	$scope.rmFriend = function(friend){
		
		var index = $scope.friendlist.indexOf(friend);
		user.$save();
		$scope.seances.splice(index,1);
	
	}
	
});


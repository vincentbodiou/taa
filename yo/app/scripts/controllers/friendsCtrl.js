'use strict';

angular.module('yoApp').controller('friendsCtrl', function($scope, $resource, $http) {

	var User = $resource('/TAA/rest/user/:userid',{userid:'@id'});
	$scope.user = User.get({userid:1}, function(){
		$scope.friendlist = $scope.user.amis;
	});
	$scope.friendlist = [{pseudo:"Vince",nom:"Baudiou",prenom:"Vincent"},{pseudo:'Okazari',nom:"Plouzennec",prenom:"Benjamin"}];
	$scope.userlist = [];
	$scope.userlist = User.query(function(){});
	$scope.userlist = [{pseudo:"Zrechim",nom:"Odermatt", prenom:"Laurent"},{pseudo:"Halta",nom:"Monvoisin",prenom:"Jean Louis"}];
	
	$scope.rmFriend = function(friend){
		
		var index = $scope.friendlist.indexOf(friend);
		$scope.userlist.push(friend);
		$scope.friendlist.splice(index,1);
		$scope.user.$save();
		
	}
	
	$scope.addFriend = function(newFriend){
	
		$scope.friendlist.push(newFriend);
		var index = $scope.userlist.indexOf(newFriend);
		$scope.userlist.splice(index,1);
		$scope.user.$save
		
	}
	
});


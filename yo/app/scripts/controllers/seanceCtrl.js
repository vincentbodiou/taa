'use strict';

angular.module('yoApp')
  .controller('seanceCtrl', function ($scope) {
    var seances = [
	{
		"id" : 1,
		"calories" : "140Kcal",
		"date" : "06-11-1991",
		"distance" : 35,
		"duree" : "3h",
		"vitesse" : "11km/h"
	},
	{
		"id" : 2,
		"calories" : "100Kcal",
		"date" : "06-10-1991",
		"distance" : 10,
		"duree" : "1h",
		"vitesse" : "10km/h"
	}];
    $scope.seances = seances;
	$scope.test = 5;
  });
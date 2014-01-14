'use strict';

angular.module('yoApp', ['ngResource'])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
	  .when('/:username/seances', {
	    templateUrl: 'views/seance.html',
		controller: 'seanceCtrl'
	  })
	  .when('/:username/friends', {
	    templateUrl: 'views/friends.html',
		controller: 'friendsCtrl'
	  });
  });
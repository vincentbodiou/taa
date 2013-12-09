'use strict';


angular.module('yoApp', ['ngResource'])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
	  .when('/seance', {
	    templateUrl: 'views/seance.html',
		controller: 'seanceCtrl'
	  });
  });
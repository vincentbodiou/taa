'use strict';


angular.module('yoApp', ['ngResource'])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
	  .when('/:username/seance', {
	    templateUrl: 'views/seance.html',
		controller: 'seanceCtrl'
	  });
  });
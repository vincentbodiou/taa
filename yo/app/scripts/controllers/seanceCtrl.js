'use strict';

angular.module('yoApp')
  .controller('seanceCtrl', function ($scope, $resource) {

	var seanceEditPosition;
	var seanceEdit;
	
	$scope.editMode = false;
	
	var Seance = $resource('/taa/rest/user/:userid/seance/:seanceid',{userid:'1'});
    /*var seances = [
	{
		"titre":"Course a pied au parc",
		"date":741034000,
		"distance":2.26,
		"duree":"13m42sec",
		"vitesse":"13",
		"calories":"840",
		"user": {
			"id":1,
            "dateNaissance":641000000,
            "nom":"b3",
            "prenom":"v3",
            "poids":150.0,
            "taille":185,
            "sexe":"M",
            "pseudo":"vince3",
            "facebook":null,
            "twitter":null,
            "mail":"vincent.bodiou3@gmail.com"
        }
	},
	{
		"titre":"Concours de course",
		"date":741034000,
		"distance":2.26,
		"duree":"4342sec",
		"vitesse":"13",
		"calories":"840",
		"user": {
			"id":1,
            "dateNaissance":641000000,
            "nom":"b3",
            "prenom":"v3",
            "poids":150.0,
            "taille":185,
            "sexe":"M",
            "pseudo":"vince3",
            "facebook":null,
            "twitter":null,
            "mail":"vincent.bodiou3@gmail.com"
        }
	}];*/
	$scope.curSeance = new Seance();
    $scope.seances = Seance.query();
	
	$scope.addNewSeance = function(){
	
		$scope.seances.push($scope.curSeance);
		$scope.curSeance.$save();
		$scope.curSeance = new Seance();
		
	}
	
	$scope.startEdit = function(s){
		$scope.curSeance = s;
		$scope.editMode = true;
	}
	
	$scope.editSeance = function(){
		$scope.curSeance.$save();
		$scope.editMode = false;
		$scope.curSeance = new Seance();
	}
  });
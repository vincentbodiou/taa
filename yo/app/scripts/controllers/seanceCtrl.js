'use strict';

angular.module('yoApp')
  .controller('seanceCtrl', function ($scope, $resource) {
	var ENR = "Enregistrer la séance";
	var MOD = "Enregistrer les modifications";
	$scope.buttonLabel = ENR;
	var Seance = $resource('/rest/user/:userid/seance/:seanceid',{userid:'toto'});
    var seances = [
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
	}];
	$scope.curSeance = new Seance();
    $scope.seances = seances;
	
	$scope.addNewSeance = function(){
	
		seances.push($scope.curSeance);
		$scope.curSeance.$save();
		$scope.curSeance = new Seance();
		
	}
	
	$scope.editSeance = function(s){
	
		$scope.seances.indexOf(s);
		$scope.curSeance = s;
		$scope.buttonLabel = MOD;
		
	}
	
	
  });
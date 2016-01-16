
var app = angular.module('blog', [ ]);

+app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
   $scope.evidenta = {};
  var url = "http://localhost:8080/persoana";
   $scope.persoane = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.person = {};
   $scope.editPerson = {};
 
   $http.get(url).then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.persoane = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addPersoana = function(persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);
        $http({
            method: 'POST',
            url: url,
            data: persoana
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(persoana);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };

	


    $scope.deletePersoana = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.persoane = $scope.persoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };

	


    $scope.setUpdatePerson = function(person) {
        $scope.editPerson = person;
    };
	
	

    $scope.updatePerson = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editPerson
        }).then(function successCallback(response) {
            $scope.editPerson = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editPerson = {};
            console.log(response);
        });
    };
	
	 var url2 = "http://localhost:8080/Evidenta";
   $scope.grupa = {};
   $scope.keysGrupa = [];
	$scope.obj2={};
   $scope.group = {};
   $scope.editGroup = {};
  $scope.orderedKeys=[];
 
	 $http.get("http://localhost:8080/Evidenta").then(
     function successCallback(response) {
     $scope.grupa = response;
     $scope.keysGrupa = Object.keys(response.data[0]);
	 $scope.orderedKeys.push($scope.keysGrupa[4]);
	 $scope.orderedKeys.push($scope.keysGrupa[0]);
	 $scope.orderedKeys.push($scope.keysGrupa[1]);
	 $scope.orderedKeys.push($scope.keysGrupa[2]);
	 $scope.orderedKeys.push($scope.keysGrupa[3]);
	
   });
 
 
 
	 $scope.addEvidenta = function(evidenta) {
    $scope.grupa.data.push(evidenta);
   $http.post("http://localhost:8080/Evidenta", evidenta);
    $scope.evidenta = {};
  };
	
	  $scope.updateEvidenta = function() {
    $http.put('http://localhost:8080/Evidenta', $scope.editEvidenta);
    $scope.editEvidenta = {};
  };
	
	
	 $scope.deleteEvidenta = function(id) {
    $http.delete('http://localhost:8080/Evidenta/' + id)
		.then(
			function successCallback(response) {
        /* code goes here */
		angular.element('[data-id=' + id + ']').remove();
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
		
    });
}
	
	 $scope.setUpdateGroup = function(group) {
        $scope.editGroup = group;
    };

	
	
	 $scope.updateGroup = function() {
    $http.put('http://localhost:8080/Evidenta', $scope.editGroup);
    $scope.editGroup = {};
  };
	
	
	
	 var url3 = "http://localhost:8080/SuperHero";
   $scope.registration = [];
   $scope.keysSuperHero = [];
	$scope.obj2={};
   $scope.superh = {};
   $scope.editsuperh = {};
 
 
	 $http.get(url3).then(
     function successCallback(response) {
		$scope.obj2=response;
     $scope.registration = response;
     $scope.keysSuperHero = Object.keys(response.data[0]);
	   });
 
 
  $scope.addSuperHero = function(SuperHero) {
    $scope.registration.data.push(SuperHero);
   $http.post("http://localhost:8080/SuperHero", SuperHero);
    $scope.SuperHero = {};
  };
  
	 $scope.deleteSuperHero = function(id) {
        $http({
            method: 'DELETE',
            url: url3+'/' + id,
            data: {}
        }).then(function successCallback(response) {
          		angular.element('[data-id=' + id + ']').remove();
        }, function errorCallback(response) {
				angular.element('[data-id=' + id + ']').remove();
            $scope.registration = $scope.registration.filter(function(obj2) {
                return obj2.id !== id;
            });
        });
    };

	
	
	 $scope.setUpdateSuperh = function(superh) {
        $scope.editsuperh = superh;
    };

	
	
	
	  $scope.updateSuperh = function() {
    $http.put('http://localhost:8080/SuperHero', $scope.editSuperh);
    $scope.editSuperh = {};
  };
	
	
	
	
	
	 var url3 = "http://localhost:8080/Carte";
   $scope.biblioteca = [];
   $scope.keysCarte = [];
	$scope.obj2={};
   $scope.book = {};
   $scope.editbook = {};
   $scope.Carte={};
 
	 $http.get(url3).then(
     function successCallback(response) {
	  $scope.biblioteca = response;
	 $scope.keysCarte = Object.keys(response.data[0]);
	   });
 
 
 

	$scope.addCarte = function(Carte) {
	 console.log("va fi adaugat:",  $scope.Carte)
    $scope.biblioteca.data.push(Carte);
	console.log("dupa adaugare:",$scope.grupa.data);
    $http.post(url3, Carte);
    $scope.Carte = {};
  };

	 $scope.deleteCarte = function(cod) {
	 console.log("id este:",cod);
    $http.delete("http://localhost:8080/Carte/" + cod)
		.then(
			function successCallback(response) {
         angular.element('[data-id=' + cod + ']').remove();
      },
      function errorCallback(response) {
        angular.element('[data-id=' + cod + ']').remove();
		
    });
}

	
	 $scope.setUpdatebook = function(book) {
        $scope.editbook = book;
    };

	
	
    $scope.updatebooko = function() {
        $http({
            method: 'PUT',
            url: url3,
            data: $scope.editbook
        }).then(function successCallback(response) {
            $scope.editbook = {};
        }, function errorCallback(response) {
            $scope.editbook = {};
            console.log(response);
        });
    };
	
	
  }]);
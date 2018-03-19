var app = angular.module('app', ["ngRoute"]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "index2.html"
    })
    .when("/index3", {
        templateUrl : "index3.html"
    });
});

app.controller('postcontroller', function($rootScope, $scope, $http, $location) {
	//to change the view
	 $scope.changeView = function(view){
         $location.path(view); // path not hash
     }
	 
	$scope.submitForm = function(){
		var url = "/customers";
		
		var config = {
                headers : {
                    'Accept': 'application/json'
                }
        }
		var data = {
				 firstname: $scope.firstname,
		            lastname: $scope.lastname,
		            mail:$scope.mail,
		            mobileNo:$scope.mobileNo,
		            address:$scope.address,
		            id:$scope.id
        };
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
		$scope.firstname = "";
		$scope.lastname = "";
		$scope.mobileNo ="";
		$scope.address = "";
		$scope.mail = "";
		$scope.id = "";
		
		//to load the table after adding new customer details
		$rootScope.$broadcast('topic', 'some message message');
	}
});
 
app.controller('getcontroller', function($rootScope, $scope, $http, $location) {
	//to load the table after adding new customer details
    $scope.$on('topic', function (event, arg) { 
	    //$scope.receiver = 'got your ' + arg;
	  $scope.getfunction();
	});
	  
	$scope.getfunction = function(){
		var url =  "/customers";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
	
	$scope.editRow = function(cust) {
		cust.editMode = true;
	}
	
	$scope.cancleRow = function(cust) {
		cust.editMode = false;
		$scope.getfunction();
	}
	
	$scope.updateCustomer = function(cust, id){
		cust.editMode = false;
		
		var url = "/customers/"+id;
		
		var config = {
                headers : {
                    'Accept': 'application/json'
                }
        }
		var data = {
            firstname: cust.firstname,
            lastname:  cust.lastname,
            mail:  cust.mail,
            mobileNo:  cust.mobileNo,
            address:  cust.address,
            id:  cust.id
        };
		
		$http.put(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
	
	$scope.removeCustomer = function(id){
		var url = "/customers/"+id;
		
		var config = {
                headers : {
                    'Accept': 'application/json'
                }
        }
		var data = {
        };
		
		$http.delete(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
		$scope.getfunction();
	}
});

//for sharing service between FirstCtrl and SecondCtrl
app.factory('theService', function() {  
    return {
        thing : {
            x : 100
        }
    };
});

app.controller('FirstCtrl', function ($scope, $http, $location, theService) {
	//to change the view
	 $scope.changeView = function(view){
         $location.path(view); // path not hash
     }
	 
    $scope.thing = theService.thing;
    $scope.name = "First Controller";
    //theService.thing.x = 200;
});

app.controller('SecondCtrl', function ($scope, theService) {   
    $scope.someThing = theService.thing; 
    $scope.name = "Second Controller!";
});

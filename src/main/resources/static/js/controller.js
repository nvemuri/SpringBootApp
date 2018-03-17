var app = angular.module('app', []);

app.controller('postcontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
		var url = $location.absUrl() + "postcustomer";
		
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
		
	}
});
 
app.controller('getcontroller', function($scope, $http, $location) {
	$scope.getfunction = function(){
		var url = $location.absUrl() + "getallcustomer";
		
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
	}
	
	$scope.updateCustomer = function(cust, id){
		cust.editMode = false;
		
		var url = $location.absUrl() + "updatecustomer";
		
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
		var url = $location.absUrl() + "removecustomer/"+id;
		
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

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
});

app.controller('updatecontroller', function($scope, $http, $location) {
	$scope.editCustomer = function(id){
		var url = $location.absUrl() + "updatecustomer";
		
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
		
		$http.put(url, data, config).then(function (response) {
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
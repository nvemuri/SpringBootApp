var app = angular.module('app', []);

app.controller('postcontroller', function($rootScope, $scope, $http, $location) {
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
		
		// to load the table after adding new customer details
		$rootScope.$broadcast('topic', 'some message message');
	}
});
 
app.controller('getcontroller', function($scope, $http, $location) {
	
	// to load the table after adding new customer details
    $scope.$on('topic', function (event, arg) { 
	    // $scope.receiver = 'got your ' + arg;
    	// alert(arg);
	  $scope.getfunction();
	});
    
	$scope.getfunction = function(){
		var url = "/customers";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
	
	$scope.searchCustomers = function() {
		var url = $location.absUrl() + "searchCustomer";
 
		var config = {
				headers : {
                    'Accept': 'application/json'
                },
		
                params: { 'name' : $scope.searchText }
		}
 
		$http.get(url, config).then(function(response) {
			$scope.response = response.data
		}, function(response) {
			$scope.postResultMessage = "Fail!";
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

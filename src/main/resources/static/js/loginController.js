
//login functionality controller.
app.controller('loginController', function($rootScope,$scope, $http, $location, LoginService) {
	$rootScope.title = "AngularJS Login Sample";
	$scope.login = function() {
	if(LoginService.login($scope.username, $scope.password)) {
		$rootScope.userName = $scope.username;
		$scope.error = '';
		$scope.username = '';
		$scope.password = '';
		$state.transitionTo('customer');
	} else {
		$scope.error = "Incorrect username/password !";
	}   
};
});

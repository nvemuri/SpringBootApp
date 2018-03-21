
var app = angular.module('app', ['ui.router']);

app.config(['$stateProvider', '$urlRouterProvider', 
function($stateProvider, $urlRouterProvider) {
	
	$stateProvider
	.state('login', {
url : '/login',
templateUrl : 'login.html',
controller : 'loginController'
})
.state('customer', {
url : '/customer',
templateUrl : 'customer.html',
controller : 'postcontroller'
});
$urlRouterProvider.otherwise('/login');
}]);
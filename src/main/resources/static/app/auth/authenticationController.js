angular.module('app')
.controller('AuthenticationController', function($rootScope, $location, AuthenticationService) {
    this.credentials = {};
	var loginSuccess = function() {
		$rootScope.authenticated = true;
		$location.path('/new');
	}
    this.login = function() {
		AuthenticationService.authenticate(this.credentials, loginSuccess);
	}
	var logoutSuccess = function() {
		$rootScope.authenticated = false;
		$location.path('/');
	}
    this.logout = function() {
		AuthenticationService.logout(logoutSuccess);
	}
});
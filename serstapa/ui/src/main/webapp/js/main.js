var app = angular.module('serstapa', []);

/**
 * Controller to manage the services.
 */
app.controller("ServicesController", [ "$scope", "$http", function($scope, $http) {
	$http.get("http://localhost:8080/restapi/services?callback=JSON_CALLBACK")
	.success(function(data, status) {
		$scope.services = data;
	}).error(function(data, status) {

	});
} ]);
var app = angular.module('serstapa', []);

/**
 * Controller to manage the services.
 */
app.controller("ServicesController", [ "$scope", function($scope) {
	$scope.services = [ {
		"name" : "Service A",
		"status" : "running"
	}, {
		"name" : "Service B",
		"status" : "offline"
	} ];
} ]);
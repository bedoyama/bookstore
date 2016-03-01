'use strict';

/* Controllers */

var bookstoreControllers = angular.module('bookstoreControllers', []);

function MyController($scope, Publisher) {
	$scope.currentPage = 1;
	$scope.pageSize = 10;

	 Publisher.query(function(data) {
		 $scope.publishers = data;
	 });

	$scope.pageChangeHandler = function(num) {
		console.log('meals page changed to ' + num);
	};
}

function OtherController($scope) {
	$scope.pageChangeHandler = function(num) {
		console.log('going to page ' + num);
	};
}

bookstoreControllers.controller('MyController', [ '$scope', 'Publisher', MyController ]);
bookstoreControllers.controller('OtherController', [ '$scope', OtherController ]);

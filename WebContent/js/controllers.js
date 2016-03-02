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

function EditController($scope, $stateParams, Publisher) {
    $scope.publisherId = $stateParams.publisherId;
	 Publisher.get({publisherId: $stateParams.publisherId} ,function(data) {
		 $scope.publisher = data;
	 });


}

bookstoreControllers.controller('MyController', [ '$scope', 'Publisher', MyController ]);
bookstoreControllers.controller('OtherController', [ '$scope', OtherController ]);
bookstoreControllers.controller('EditController', [ '$scope', '$stateParams', 'Publisher', EditController ]);

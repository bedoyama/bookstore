// Code goes here

var myApp = angular.module('myApp', [ 'angularUtils.directives.dirPagination',
		'bookstoreServices' ]);

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

myApp.controller('MyController', [ '$scope', 'Publisher', MyController ]);
myApp.controller('OtherController', [ '$scope', OtherController ]);
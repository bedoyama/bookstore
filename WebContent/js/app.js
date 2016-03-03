// Code goes here

var myApp = angular.module('myApp', [ 'angularUtils.directives.dirPagination',
		'ui.router', 'bookstoreControllers', 'bookstoreServices' ]);

myApp.run(['$rootScope', '$location', function($rootScope, $location) {
	  $rootScope.$location = $location;
	}]);

myApp.config(function($stateProvider, $locationProvider, $urlRouterProvider) {
	$urlRouterProvider
	.otherwise("/home");

	$stateProvider
	.state('home', {
		url : "/home",
		views : {
			"topFrame" : {
				templateUrl : 'parts/publisherList.html',
				controller : 'MyController'
			},
			"bottomFrame" : {
				templateUrl : 'parts/defaultBottomPaginator.html',
				controller : 'PaginationController'
			}
		}
	})
	.state('publisherList', {
		url : "/publist",
		views : {
			"topFrame" : {
				templateUrl : 'parts/publisherList.html',
				controller : 'MyController'
			},
			"bottomFrame" : {
				templateUrl : 'parts/defaultBottomPaginator.html',
				controller : 'PaginationController'
			}
		}
	})
	.state('publisherEdit', {
		url : "/pubedit",
		views : {
			"topFrame" : {
				templateUrl : 'parts/publisherEdit.html',
				controller : function($scope) {
				    $scope.publisherId = -1;
				}
			},
			"bottomFrame" : {
				templateUrl : 'parts/blank.html'
			}
		}
	})
	.state('publisherEditDetail', {
		url : "/pubedit/:publisherId",
		views : {
			"topFrame" : {
				templateUrl : 'parts/publisherEdit.html',
				controller : 'EditController'
			},
			"bottomFrame" : {
				templateUrl : 'parts/blank.html'
			}
		}
	});
});

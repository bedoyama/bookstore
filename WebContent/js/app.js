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
			"viewA" : {
				templateUrl : 'parts/viewA.html',
				controller : 'MyController'
			},
			"viewB" : {
				templateUrl : 'parts/viewB.html',
				controller : 'OtherController'
			}
		}
	})
	.state('edit', {
		url : "/edit",
		views : {
			"viewA" : {
				templateUrl : 'parts/editpub.html',
				controller : function($scope) {
				    $scope.publisherId = -1;
				}
			},
			"viewB" : {
				templateUrl : 'parts/blank.html'
			}
		}
	})
	.state('editDetail', {
		url : "/edit/:publisherId",
		views : {
			"viewA" : {
				templateUrl : 'parts/editpub.html',
				controller : 'EditController'
			},
			"viewB" : {
				templateUrl : 'parts/blank.html'
			}
		}
	});
});

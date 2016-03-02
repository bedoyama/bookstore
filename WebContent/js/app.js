// Code goes here

var myApp = angular.module('myApp', [ 'angularUtils.directives.dirPagination',
		'ui.router', 'bookstoreControllers', 'bookstoreServices' ]);

myApp.run([ '$rootScope', '$state', '$stateParams',
		function($rootScope, $state, $stateParams) {
			$rootScope.$state = $state;
			$rootScope.$stateParams = $stateParams;
		} ]);

myApp.config(function($stateProvider, $locationProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/");
	$locationProvider.html5Mode(false).hashPrefix('!');
	$stateProvider
	.state('home', {
		url : "/",
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
		url : "/",
		views : {
			"viewA" : {
				templateUrl : 'parts/editpub.html',
			},
			"viewB" : {
				templateUrl : 'parts/blank.html',
			}
		}
	});
});

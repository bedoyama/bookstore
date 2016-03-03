// Code goes here

var myApp = angular.module('myApp', [ 'angularUtils.directives.dirPagination',
		'ui.router', 'bookPublisherControllers', 'bookAuthorControllers', 'bookstoreServices' ]);

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
				controller : 'PublisherListCtrl'
			},
			"bottomFrame" : {
				templateUrl : 'parts/defaultBottomPaginator.html',
				controller : 'PaginationController'
			}
		}
	})
	.state('authorList', {
		url : "/authorlist",
		views : {
			"topFrame" : {
				templateUrl : 'parts/authorList.html',
				controller : 'AuthorListCtrl'
			},
			"bottomFrame" : {
				templateUrl : 'parts/defaultBottomPaginator.html',
				controller : 'PaginationController'
			}
		}
	})
	.state('authorEdit', {
		url : "/authoredit",
		views : {
			"topFrame" : {
				templateUrl : 'parts/authorEdit.html',
				controller : 'AuthorEditCtrl'
			},
			"bottomFrame" : {
				templateUrl : 'parts/blank.html'
			}
		}
	})
	.state('authorEditDetail', {
		url : "/authoredit/:authorId",
		views : {
			"topFrame" : {
				templateUrl : 'parts/authorEdit.html',
				controller : 'AuthorEditCtrl'
			},
			"bottomFrame" : {
				templateUrl : 'parts/blank.html'
			}
		}
	})
	.state('publisherList', {
		url : "/publist",
		views : {
			"topFrame" : {
				templateUrl : 'parts/publisherList.html',
				controller : 'PublisherListCtrl'
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
				controller : 'PublisherEditCtrl'
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
				controller : 'PublisherEditCtrl'
			},
			"bottomFrame" : {
				templateUrl : 'parts/blank.html'
			}
		}
	});
});

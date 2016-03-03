'use strict';

/* Services */

var bookstoreServices = angular.module('bookstoreServices', [ 'ngResource' ]);

bookstoreServices.factory('Publisher', [ '$resource', function($resource) {
	return $resource('/bookstore/publisher/:publisherId', null, {
		'update' : {
			method : 'PUT'
		}
	});
} ]);

bookstoreServices.factory('Author', [ '$resource', function($resource) {
	return $resource('/bookstore/author/:authorId', null, {
		'update' : {
			method : 'PUT'
		}
	});
} ]);

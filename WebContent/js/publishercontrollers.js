'use strict';

/* Controllers */

var bookPublisherControllers = angular.module('bookPublisherControllers', []);

function PublisherListCtrl($scope, Publisher) {
	$scope.currentPage = 1;
	$scope.pageSize = 10;

	 Publisher.query(function(data) {
		 $scope.publishers = data;
	 });

	$scope.pageChangeHandler = function(num) {
		console.log('meals page changed to ' + num);
	};
	
	$scope.deleteent= function (publisher){
		Publisher.remove({ publisherId:publisher.publisherId });
	}
}

function PaginationController($scope) {
	$scope.pageChangeHandler = function(num) {
		console.log('going to page ' + num);
	};
}

function PublisherEditCtrl($scope, $stateParams, Publisher) {
    $scope.publisherId = $stateParams.publisherId;
	$scope.master = {};
	 
    $scope.update = function(publisher) {
      $scope.master = angular.copy(publisher);
      Publisher.update({ publisherId:publisher.publisherId }, publisher);
    };

    $scope.reset = function() {
      $scope.publisher = angular.copy($scope.master);
    };

    Publisher.get({publisherId: $stateParams.publisherId} ,function(data) {
	  $scope.publisher = data;
	  $scope.update($scope.publisher);
	});
     

}

bookPublisherControllers.controller('PublisherListCtrl', [ '$scope', 'Publisher', PublisherListCtrl ]);
bookPublisherControllers.controller('PaginationController', [ '$scope', PaginationController ]);
bookPublisherControllers.controller('PublisherEditCtrl', [ '$scope', '$stateParams', 'Publisher', PublisherEditCtrl ]);

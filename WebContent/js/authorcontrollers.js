'use strict';

/* Controllers */

var bookAuthorControllers = angular.module('bookAuthorControllers', []);

function AuthorListCtrl($scope, Author) {
	$scope.currentPage = 1;
	$scope.pageSize = 10;

	 Author.query(function(data) {
		 $scope.authors = data;
	 });

	$scope.pageChangeHandler = function(num) {
		console.log('meals page changed to ' + num);
	};
	
	$scope.deleteent= function (author){
		Author.remove({ authorId:author.authorId });
	}
}

function AuthorEditCtrl($scope, $stateParams, Author) {
    $scope.authorId = $stateParams.authorId;
	$scope.master = {};
	 
    $scope.update = function(author) {
      $scope.master = angular.copy(author);
      Author.update({ authorId:author.authorId }, author);
    };

    $scope.reset = function() {
      $scope.author = angular.copy($scope.master);
    };

    Author.get({authorId: $stateParams.authorId} ,function(data) {
	  $scope.author = data;
	  $scope.update($scope.author);
	});
     

}

bookAuthorControllers.controller('AuthorListCtrl', [ '$scope', 'Author', AuthorListCtrl ]);
bookAuthorControllers.controller('AuthorEditCtrl', [ '$scope', '$stateParams', 'Author', AuthorEditCtrl ]);

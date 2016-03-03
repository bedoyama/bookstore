'use strict';

/* Controllers */

var bookBookControllers = angular.module('bookBookControllers', []);

function BookListCtrl($scope, Book) {
	$scope.currentPage = 1;
	$scope.pageSize = 10;

	 Book.query(function(data) {
		 $scope.books = data;
	 });

	$scope.pageChangeHandler = function(num) {
		console.log('meals page changed to ' + num);
	};
	
	$scope.deleteent= function (book){
		Book.remove({ bookId:book.bookId });
	}
}

function BookEditCtrl($scope, $stateParams, Book) {
    $scope.bookId = $stateParams.bookId;
	$scope.master = {};
	 
    $scope.update = function(book) {
      $scope.master = angular.copy(book);
      Book.update({ bookId:book.bookId }, book);
    };

    $scope.reset = function() {
      $scope.book = angular.copy($scope.master);
    };

    Book.get({bookId: $stateParams.bookId} ,function(data) {
	  $scope.book = data;
	  $scope.update($scope.book);
	});
     

}

bookBookControllers.controller('BookListCtrl', [ '$scope', 'Book', BookListCtrl ]);
bookBookControllers.controller('BookEditCtrl', [ '$scope', '$stateParams', 'Book', BookEditCtrl ]);

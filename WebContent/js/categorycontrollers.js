'use strict';

/* Controllers */

var bookCategoryControllers = angular.module('bookCategoryControllers', []);

function CategoryListCtrl($scope, Category) {
	$scope.currentPage = 1;
	$scope.pageSize = 10;

	 Category.query(function(data) {
		 $scope.categorys = data;
	 });

	$scope.pageChangeHandler = function(num) {
		console.log('meals page changed to ' + num);
	};
	
	$scope.deleteent= function (category){
		Category.remove({ categoryId:category.categoryId });
	}
}

function CategoryEditCtrl($scope, $stateParams, Category) {
    $scope.categoryId = $stateParams.categoryId;
	$scope.master = {};
	 
    $scope.update = function(category) {
      $scope.master = angular.copy(category);
      Category.update({ categoryId:category.categoryId }, category);
    };

    $scope.reset = function() {
      $scope.category = angular.copy($scope.master);
    };

    Category.get({categoryId: $stateParams.categoryId} ,function(data) {
	  $scope.category = data;
	  $scope.update($scope.category);
	});
     

}

bookCategoryControllers.controller('CategoryListCtrl', [ '$scope', 'Category', CategoryListCtrl ]);
bookCategoryControllers.controller('CategoryEditCtrl', [ '$scope', '$stateParams', 'Category', CategoryEditCtrl ]);

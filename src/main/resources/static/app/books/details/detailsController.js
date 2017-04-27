angular.module('app')

.controller('DetailsController', function($routeParams, Books) {

	var bookIndex = $routeParams.id;

    this.book = Books.getBook(bookIndex);

});
angular.module('app')

.constant('BOOK_ENDPOINT', '/books/:id')

.factory('Book', function($resource, BOOK_ENDPOINT) {
	return $resource(BOOK_ENDPOINT);
})

.service('Books', function(Book) {
	this.getBooks = function() {
		return Book.query();
	}
	this.getBook = function(index) {
		return Book.get({id: index});
	}
	this.add = function(book) {
		book.$save({});
	}
});
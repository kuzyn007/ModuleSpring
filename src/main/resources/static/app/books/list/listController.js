angular.module('app')

.controller('ListController', function(Books) {

    this.books = Books.getBooks();

});
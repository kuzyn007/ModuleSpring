angular.module('app')

.controller('NewController', function(Books, Book) {

    this.book = new Book();

    this.saveBook = function() {
        Books.add(this.book);
        this.book = new Book();
	}

});
package pl.javastart.book.domain;

import pl.javastart.book.dto.BookDto;

import static java.util.Objects.requireNonNull;

/**
 * Created by Seweryn Adamczyk on 2017-04-26.
 */
class BookCreator {
    Book from(BookDto bookDto) {
        requireNonNull(bookDto);
        return Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .build();
    }
}

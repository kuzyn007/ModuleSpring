package pl.seweryn.book.domain;

import org.springframework.util.Assert;
import pl.seweryn.book.dto.BookDto;

/**
 * Created by Seweryn Adamczyk on 2017-04-26.
 */
class BookCreator {
    Book from(BookDto bookDto) {
        Assert.notNull(bookDto, "BookDto must not be null.");
        return Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .build();
    }
}

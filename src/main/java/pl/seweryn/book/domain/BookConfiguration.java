package pl.seweryn.book.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Seweryn Adamczyk on 2017-04-26.
 */

@Configuration
class BookConfiguration {
    @Bean
    BookFacade bookFacade(BookRepository bookRepository) {
        BookCreator bookCreator = new BookCreator();
        return new BookFacade(bookRepository, bookCreator);
    }

}

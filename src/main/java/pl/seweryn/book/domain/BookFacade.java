package pl.seweryn.book.domain;

import org.springframework.util.Assert;
import pl.seweryn.book.dto.BookDto;
import pl.seweryn.book.exceptions.BookNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;


/**
 * Created by Seweryn Adamczyk on 2017-04-26.
 */
public class BookFacade {
    private BookRepository bookRepository;
    private BookCreator bookCreator;

    public BookFacade(BookRepository bookRepository, BookCreator bookCreator) {
        this.bookRepository = bookRepository;
        this.bookCreator = bookCreator;
    }

    public List<BookDto> findAll() {
        return bookRepository
                .findAll().stream()
                .map(book -> book.dto())
                .collect(Collectors.toList());
    }

    public BookDto findOne(Long id) throws BookNotFoundException {
        Assert.notNull(id, "Book id must not be null.");
        Book book = bookRepository.findOne(id);
        return book.dto();
    }

    public BookDto add(BookDto bookDto) {
        Assert.notNull(bookDto, "BookDto must not be null.");
        Book book = bookCreator.from(bookDto);
        book = bookRepository.save(book);
        return book.dto();
    }
}

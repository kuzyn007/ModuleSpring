package pl.javastart.book.domain;

import pl.javastart.book.dto.BookDto;

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

    public BookDto findOne(Long id) {
        requireNonNull(id);
        Book book = bookRepository.findOne(id);
        return book.dto();
    }

    public BookDto add(BookDto bookDto) {
        requireNonNull(bookDto);
        Book book = bookCreator.from(bookDto);
        book = bookRepository.save(book);
        return book.dto();
    }
}

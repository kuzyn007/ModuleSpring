package pl.javastart.book;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.javastart.book.domain.BookFacade;
import pl.javastart.book.dto.BookDto;

import java.util.logging.Logger;


@RestController
class BookEndpoint {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private BookFacade bookFacade;

    public BookEndpoint(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping("books")
    List<BookDto> getBooks() {
        logger.info("Getting books list!");
        return bookFacade.findAll();
    }
    
    @GetMapping("books/{id}")
    BookDto getBook(@PathVariable Long id) {
        return bookFacade.findOne(id);
    }
    
    @PostMapping("books")
    BookDto add(@RequestBody BookDto bookDto) {
        BookDto saved = bookFacade.add(bookDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("book/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return saved;
    }
}
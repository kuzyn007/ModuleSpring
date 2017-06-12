package pl.seweryn.book;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.seweryn.book.domain.BookFacade;
import pl.seweryn.book.dto.BookDto;



@RestController
class BookEndpoint {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private BookFacade bookFacade;

    public BookEndpoint(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping(path = "/books")
    List<BookDto> getBooks() {
        logger.info("Getting books list!");
        return bookFacade.findAll();
    }
    
    @GetMapping(path = "/books/{id}")
    BookDto getBook(@PathVariable Long id) {
        return bookFacade.findOne(id);
    }
    
    @PostMapping(path = "/books")
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
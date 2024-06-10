package library.app.backend.book;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("book")
public class BookController {
    public BookController() {}

    @GetMapping()
    public List<Book> get() {
        return new ArrayList<Book>();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable UUID id) {
        return new Book();
    }

    @PostMapping()
    public Book post(@RequestBody Book book) {
        return new Book();
    }

    @PutMapping()
    public Book put() {
        return new Book();
    }

    @DeleteMapping("/{id}")
    public Book deleteById(@PathVariable UUID id) {
        return new Book();
    }
}

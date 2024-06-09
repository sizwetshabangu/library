package library.app.backend.book;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("book")
public class BookController {
    public BookController() {}

    @GetMapping()
    public List<Book> get() {
        return new ArrayList<Book>();
    }

    @GetMapping()
    public Book getById() {
        return new Book();
    }

    @PostMapping()
    public Book post() {
        return new Book();
    }

    @PutMapping()
    public Book put() {
        return new Book();
    }

    @DeleteMapping()
    public Book deleteById() {
        return new Book();
    }
}

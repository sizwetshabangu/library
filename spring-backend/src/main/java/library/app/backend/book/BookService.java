package library.app.backend.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> find(){
        return bookRepository.findAll();
    }

    public Book find(UUID id) throws NoSuchElementException{
        return this.bookRepository.findById(id).orElseThrow();
    }

    public Book create(Book book){
        return this.bookRepository.save(book);
    }

    public Book update(Book book){
        return this.bookRepository.save(book);
    }

    public void delete(UUID id){
        this.bookRepository.deleteById(id);
    }
}

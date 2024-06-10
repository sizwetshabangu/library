package library.app.backend.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import library.app.backend.category.Category;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link Book}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDto(
        UUID id,
        String isbn,
        List<Category> category,
        String title,
        String author,
        String language,
        Integer publicationYear,
        String publisher,
        String image,
        Byte isAvailable)
        implements Serializable {

    public BookDto tobookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getIsbn(),
                book.getCategory(),
                book.getTitle(),
                book.getAuthor(),
                book.getLanguage(),
                book.getPublicationYear(),
                book.getPublisher(),
                book.getImage(),
                book.getIsAvailable()
        );
    }
}
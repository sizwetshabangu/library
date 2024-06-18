package library.app.backend.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import library.app.backend.category.Category;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link Book}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class BookDto extends RepresentationModel<BookDto> implements Serializable {
        UUID id;
        String isbn;
        List<Category> category;
        String title;
        String author;
        String language;
        Integer publicationYear;
        String publisher;
        String image;
        Byte isAvailable;

    public BookDto toBookDto(Book book) {
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
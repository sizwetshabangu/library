package library.app.backend.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link Book}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDto(String id, String isbn, String category, String title, String author, String language,
                      Integer publicationYear, String publisher, String image,
                      Byte isAvailable) implements Serializable {
}
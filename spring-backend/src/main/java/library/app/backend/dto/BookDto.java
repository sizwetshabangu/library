package library.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link library.app.backend.models.Book}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDto(String id, String isbn, String category, String title, String author, String language,
                      Integer publicationYear, String publisher, String image,
                      Byte isAvailable) implements Serializable {
}
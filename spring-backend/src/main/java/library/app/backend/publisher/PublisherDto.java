package library.app.backend.publisher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link Publisher}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PublisherDto(String id, String name) implements Serializable {
}
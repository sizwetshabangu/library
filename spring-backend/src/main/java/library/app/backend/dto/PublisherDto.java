package library.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link library.app.backend.models.Publisher}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PublisherDto(String id, String name) implements Serializable {
}
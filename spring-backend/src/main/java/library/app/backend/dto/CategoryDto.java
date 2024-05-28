package library.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link library.app.backend.models.Category}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoryDto(UUID id, String name, String description) implements Serializable {
}
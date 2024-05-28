package library.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link library.app.backend.models.Reader}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ReaderDto(String id, String firstName, String lastName, String email, String phone, String address,
                        Instant createdAt) implements Serializable {
}
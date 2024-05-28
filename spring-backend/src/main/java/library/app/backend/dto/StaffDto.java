package library.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link library.app.backend.models.Staff}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record StaffDto(String id, String firstName, String lastName, String email, String phone,
                       String address) implements Serializable {
}
package library.app.backend.staff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link Staff}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record StaffDto(String id, String firstName, String lastName, String email, String phone,
                       String address) implements Serializable {
}
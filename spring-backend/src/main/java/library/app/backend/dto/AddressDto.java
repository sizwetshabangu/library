package library.app.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link library.app.backend.models.Address}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AddressDto(String id, Integer houseNumber, String street, String city, String province, String country,
                         Integer postalCode) implements Serializable {
}
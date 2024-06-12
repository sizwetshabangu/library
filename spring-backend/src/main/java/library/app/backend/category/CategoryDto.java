package library.app.backend.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Category}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoryDto(
        UUID id,
        String name,
        String description
) implements Serializable{

    public static CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getDescription());
    }
}
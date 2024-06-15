package library.app.backend.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Category}
 */
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class CategoryDto extends RepresentationModel<CategoryDto> implements Serializable{
    private UUID id;
    private String name;
    private String description;

    public static CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getDescription());
    }
}
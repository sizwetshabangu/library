package library.app.backend.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.hateoas.RepresentationModel;

import java.time.Instant;
import java.util.UUID;

@JsonIgnoreProperties({"createdAt", "deletedAt", "deleted", "deletedBy", "createdBy", "updatedBy", "updatedAt"})
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category extends RepresentationModel<Category> {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String description;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate()
    private Instant updatedAt;

    @Column()
    private Instant deletedAt;

    @Column(nullable = false)
    private Boolean deleted;

    @Column()
    private UUID deletedBy;

    @Column()
    private UUID updatedBy;

    @Column()
    private UUID createdBy;
}
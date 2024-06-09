package library.app.backend.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Instant createdAt;

    @Column()
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
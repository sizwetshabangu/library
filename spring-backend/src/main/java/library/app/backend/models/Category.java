package library.app.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Column(name = "deletedAt")
    private Instant deletedAt;

    @ColumnDefault("0")
    @Column(name = "deleted", nullable = false)
    private Byte deleted;

    @Column(name = "deletedBy")
    private String deletedBy;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "createdBy", nullable = false)
    private String createdBy;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

}
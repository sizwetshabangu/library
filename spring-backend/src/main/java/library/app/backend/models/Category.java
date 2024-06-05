package library.app.backend.models;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 36)
    private UUID id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Instant createdAt;

    @Column()
    private Instant updatedAt;

    @Column()
    private Instant deletedAt;

    @ColumnDefault("false")
    @Column(nullable = false)
    private Boolean deleted;

    @Column()
    private UUID deletedBy;

    @Column()
    private UUID updatedBy;

    @Column(nullable = false)
    private UUID createdBy;

    @Column(nullable = false, length = 100)
    private String name;

}
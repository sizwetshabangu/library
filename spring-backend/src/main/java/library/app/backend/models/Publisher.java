package library.app.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private Instant updatedAt;

    @Column(name = "deletedAt")
    private Instant deletedAt;

    @Column(name = "deleted", nullable = false)
    private Byte deleted;

    @Column(name = "deletedBy")
    private String deletedBy;

    @Column(name = "updatedBy")
    private String updatedBy;

    @Column(name = "createdBy", nullable = false)
    private String createdBy;

}
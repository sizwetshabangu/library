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
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Instant updatedAt;

    @Column(name = "deletedAt", nullable = false)
    private Instant deletedAt;

    @Column(name = "deleted", nullable = false)
    private Byte deleted;

    @Column(name = "deletedBy", nullable = false)
    private String deletedBy;

    @Column(name = "updatedBy", nullable = false)
    private String updatedBy;

    @Column(name = "createdBy", nullable = false)
    private String createdBy;

}
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
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "publicationYear", nullable = false)
    private Integer publicationYear;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "isAvailable", nullable = false)
    private Byte isAvailable;

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
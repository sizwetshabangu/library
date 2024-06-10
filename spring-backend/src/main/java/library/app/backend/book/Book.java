package library.app.backend.book;

import jakarta.persistence.*;
import library.app.backend.category.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String isbn;

    @ManyToOne()
    private Category category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private Integer publicationYear;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Byte isAvailable;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    @Column()
    private Instant deletedAt;

    @Column(name = "deleted", nullable = false)
    private Byte deleted;

    @Column()
    private UUID deletedBy;

    @Column()
    private UUID updatedBy;

    @Column()
    private UUID createdBy;

}
package library.app.backend.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import library.app.backend.category.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.hateoas.RepresentationModel;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"createdAt", "deletedAt", "deleted", "deletedBy", "createdBy", "updatedBy", "updatedAt"})
@Table(name = "book")
public class Book extends RepresentationModel<Book> {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String isbn;

    @OneToMany()
    private List<Category> category;

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
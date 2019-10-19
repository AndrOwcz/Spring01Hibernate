package pl.coderslab.app.book;

import pl.coderslab.app.author.Author;
import pl.coderslab.app.publisher.Publisher;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, groups = {PropositionValidationGroup.class, BookValidationGroup.class})
    @NotBlank(groups = {PropositionValidationGroup.class, BookValidationGroup.class})
    @Column(nullable = false)
    private String title;

    @Min(value = 1, groups = BookValidationGroup.class)
    @Max(value = 10, groups = BookValidationGroup.class)
    @Column(scale = 2, precision = 4)
    private BigDecimal rating;

    @Size(max = 600, min = 1, groups = {PropositionValidationGroup.class, BookValidationGroup.class})
    @NotBlank(groups = {PropositionValidationGroup.class, BookValidationGroup.class})
    private String description;

    @Min(value = 2, groups = BookValidationGroup.class)
    private Long pages;

    @NotNull(groups = BookValidationGroup.class)
    @ManyToOne
    private Publisher publisher;

    @NotNull(groups = BookValidationGroup.class)
    @NotEmpty(groups = BookValidationGroup.class)
    @ManyToMany
    private List<Author> authors;

    private boolean proposition;

    @ManyToOne
    private Category category;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", pages=" + pages +
                ", publisher=" + publisher +
                ", authors=" + authors +
                ", proposition=" + proposition +
                '}';
    }
}

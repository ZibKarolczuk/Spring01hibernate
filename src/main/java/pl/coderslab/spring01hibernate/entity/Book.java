package pl.coderslab.spring01hibernate.entity;

import pl.coderslab.spring01hibernate.validation.BookProposition;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Tytul musi zawierac co najmniej 5 znakow",
             groups = {BookProposition.class, Default.class})
    @Size(min = 5, message = "Tytul musi zawierac co najmniej 5 znakow",
          groups = {BookProposition.class, Default.class})
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @Size(min = 1)
    private List<Author> authors = new ArrayList<>();


    // below field is only for validation test purposes
//    @Transient
//    @NotNull
//    public Author author;

    @Min(1)
    @Max(10)
    private int rating;

    @Column(columnDefinition = "TEXT")
    @Size(max = 600, groups = {BookProposition.class, Default.class})
    private String description;

    @ManyToOne
    @NotNull
    private Publisher publisher;

    @Min(2)
    private int pages;

    private boolean proposition=false;

    public Book(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> author) {
        this.authors = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean propositon) {
        this.proposition = propositon;
    }
}

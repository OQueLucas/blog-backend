package com.oquelucas.blog.domain.post;

import com.oquelucas.blog.domain.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime createdAt;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String excerpt;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "post_categories", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "category")
    private List<String> categories = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();

    public Post(OffsetDateTime createdAt, String title, String content, String excerpt, User author) {
        this.createdAt = createdAt;
        this.title = title;
        this.content = content;
        this.excerpt = excerpt;
        this.author = author;
    }
}

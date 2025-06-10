package com.oquelucas.blog.domain.post;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime updatedAt;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;

    public Tag(String name, String description) {
        this.name = name;
        this.slug = name.toLowerCase().replace(" ", "-");
        this.description = description;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }
}
package com.oquelucas.blog.domain.post;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }

    public Category(String name, String description, Category parent) {
        this.name = name;
        this.description = description;
        this.slug = name.toLowerCase().replace(" ", "-");
        this.parent = parent;
    }
}

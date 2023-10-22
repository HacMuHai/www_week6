package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "published")
    private boolean published;
    @Column(name = "content", columnDefinition = "tinytext")
    private String content;
    @Column(name = "meta_title",columnDefinition = "varchar(100)")
    private String metaTittle;
    @Column(name = "summary", columnDefinition = "tinytext")
    private String summary;
    @Column(name = "create_at",columnDefinition = "datetime(6)")
    private Instant createAt;
    @Column(name = "title",columnDefinition = "varchar(75)")
    private String title;
    @Column(name = "update_at")
    private Instant updateAt;
    @Column(name = "published_at")
    private Instant publishedAt;

    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;


}

package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "post_comment")
@Getter
@Setter
public class PostComment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",columnDefinition = "varchar(100)")
    private String title;
    @Column(name = "published")
    private Boolean published;
    @Lob
    @Column(name = "content",columnDefinition = "text")
    private String content;
    @Column(name = "published_at")
    private Instant publishedAt;
    @Column(name = "createAt")
    private Instant createAt;


    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment parent;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

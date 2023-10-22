package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "middle_name",columnDefinition = "varchar(50)")
    private String middleName;
    @Column(name = "first_name",columnDefinition = "varchar(50)")
    private String firstName;
    @Column(name = "last_name",columnDefinition = "varchar(50)")
    private String lastName;
    @Column(name = "intro",columnDefinition = "tinytext")
    private String intro;
    @Lob
    @Column(name = "profile")
    private String profile;
    @Column(name = "registered_at")
    private Instant registeredAt;
    @Column(name = "mobile",columnDefinition = "varchar(15)")
    private String mobile;
    @Column(name = "email",columnDefinition = "varchar(50)")
    private String email;
    @Column(name = "last_login")
    private Instant lastLogin;
    @Column(name = "password_hash",columnDefinition = "varchar(64)")
    private String passwordHash;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<PostComment> postComments;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private Set<Post> posts;
}

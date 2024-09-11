package sda.hibernate.one2many;

/**
 * Map Post class to 'posts' table as you did for UserEntity
 * For mapping one-to-many relationship:
 *  - declare a variable that holds a list of PostComments and initialize it with an empty list
 *  - annotate it with @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
 *  - annotate it with @JoinColumn(name = "post_id")
 *
 * Great job! You successfully map a one-to-many database relationship between two Java classes. Now lets put Hibernate on work!
 */

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Bidirectional (secondly):
 *  - declare a variable that holds a list of PostComments and initialize it with an empty list
 *  - annotate it with @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
 *  - add 2 utility methods that keeps both sides of the association in sink:
 *      - addComment - add to collection and set 'this' as parent
 *      - removeComment - remove from collection and set 'null' as parent
 */

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content")
    private String content;
    @OneToMany(mappedBy = "postVariable", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PostComment> postComments = new ArrayList<>();

    public Post() {
    }

    public Post(String content, List<PostComment> postComments) {
        this.content = content;
        this.postComments = postComments;
    }

    public Post(int id, String content, List<PostComment> postComments) {
        this.id = id;
        this.content = content;
        this.postComments = postComments;
    }

    public Post(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<PostComment> postComments) {
        this.postComments = postComments;
    }

    public void addComment(PostComment postComment){
        this.postComments.add(postComment);
        postComment.setPost(this);
    }
    public void removeComment(PostComment postComment){
        this.postComments.remove(postComment);
        postComment.setPost(null);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", postComments=" + postComments +
                '}';
    }
}


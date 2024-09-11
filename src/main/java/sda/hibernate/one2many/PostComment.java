package sda.hibernate.one2many;

/**
 * Map PostComment class to 'post_comments' table as you did for UserEntity
 */

import jakarta.persistence.*;

/**
 * Bidirectional (secondly):
 * - create an instance variable Post (add getter and setter)
 * - annotate it with @ManyToOne(fetch = FetchType.LAZY)
 */
@Entity
@Table(name = "post_comments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comment")
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post postVariable;

    public Post getPostVariable() {
        return postVariable;
    }

    public void setPost(Post postVariable) {
        this.postVariable = postVariable;
    }

    public PostComment() {
    }

    public PostComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}

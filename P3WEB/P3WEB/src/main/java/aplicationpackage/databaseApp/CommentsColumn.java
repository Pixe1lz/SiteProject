package aplicationpackage.databaseApp;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class CommentsColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_us_comment")
    private UsersColumn user;

    private String txt_comm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_post")
    private PostsColumn post;

    public UsersColumn getUser() {
        return user;
    }

    public void setUser(UsersColumn user) {
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTxt_comm() {
        return txt_comm;
    }

    public void setTxt_comm(String txt_comm) {
        this.txt_comm = txt_comm;
    }

    public void setPost(PostsColumn post) {
        this.post = post;
    }

    public PostsColumn getPost() {
        return post;
    }
}

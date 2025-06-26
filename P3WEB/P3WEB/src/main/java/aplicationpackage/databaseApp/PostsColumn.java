package aplicationpackage.databaseApp;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class PostsColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_post_us;

    private int likeCount=0;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getId_post_us() {
        return id_post_us;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_post_us(int id_post_us) {
        this.id_post_us = id_post_us;
    }


}

package aplicationpackage.databaseApp;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "users")
public class UsersColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name_us;

    private String last_name;

    @Lob
    private byte[] avatar;

    private String nickname;

    private int out_post_id;

    private long password_us;



    public int getId() {
        return id;
    }

    public int getOut_post_id() {
        return out_post_id;
    }

    public String getNickname() {
        return nickname;
    }


    public String getLast_name() {
        return last_name;
    }

    public String getName_us() {
        return name_us;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOut_post_id(int out_post_id) {
        this.out_post_id = out_post_id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public void setName_us(String name_us) {
        this.name_us = name_us;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public long getPassword_us() {
        return password_us;
    }

    public void setPassword_us(long password_us) {
        this.password_us = password_us;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}

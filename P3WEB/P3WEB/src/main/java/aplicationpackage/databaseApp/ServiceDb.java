package aplicationpackage.databaseApp;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ServiceDb {

    private final RepositoryWebPosts repositoryPosts;

    private final RepositoryWebComments repositoryComments;

    private final RepositoryWebUsers repositoryUsers;

    public ServiceDb(RepositoryWebPosts repositoryPosts,
                     RepositoryWebComments repositoryComments,
                     RepositoryWebUsers repositoryUsers) {
        this.repositoryPosts = repositoryPosts;
        this.repositoryComments = repositoryComments;
        this.repositoryUsers = repositoryUsers;
    }

    //ворк с комментариями
    public void addComment(int userId, String text, int postId) {

        UsersColumn user = repositoryUsers.findByUsersId(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        PostsColumn post = repositoryPosts.findById(postId)
                .orElseThrow(() -> new RuntimeException("Пост не найден"));

        CommentsColumn comment = new CommentsColumn();
        comment.setTxt_comm(text);
        comment.setUser(user);
        comment.setPost(post);

        repositoryComments.save(comment);

    }

    // работа с аккаунтом(личным кабинетом)
    public void createAccount(String nickname, long password) {

        UsersColumn user = new UsersColumn();
        user.setPassword_us(password);
        user.setNickname(nickname);

        repositoryUsers.save(user);
    }

    public void addAvatar(int userId, MultipartFile file) {
        UsersColumn user = repositoryUsers.findByUsersId(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        try{
            user.setAvatar(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла" + e.getMessage());
        }
    }

    public void addName(int userId, String name) {
        UsersColumn user = repositoryUsers.findByUsersId(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        user.setName_us(name);
        repositoryUsers.save(user);
    }

    public void addLastName(int userid, String lastName) {
        UsersColumn user = repositoryUsers.findByUsersId(userid)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        user.setLast_name(lastName);
        repositoryUsers.save(user);
    }

    //создание поста
    public void createPost(int userId, String content) {
        PostsColumn post = new PostsColumn();
        post.setId_post_us(userId);
        post.setContent(content);
        post.setLikeCount(0);
        repositoryPosts.save(post);

    }

    public void likePost(int postId) {
        PostsColumn post = repositoryPosts.findById(postId)
                .orElseThrow(()-> new RuntimeException("Пост не найден"));

        post.setLikeCount(post.getLikeCount()+1);
        repositoryPosts.save(post);
    }

    public List<PostsColumn> getAllPosts() {
        return repositoryPosts.findAll();
    }

}

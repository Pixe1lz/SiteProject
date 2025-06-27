package aplicationpackage;
import org.springframework.web.bind.annotation.CrossOrigin; // добавлен


import aplicationpackage.databaseApp.PostsColumn;
import aplicationpackage.databaseApp.ServiceDb;
import aplicationpackage.databaseApp.UsersColumn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Разрешает запросы с любого источника
public class Controller {

    private final ServiceDb service;

    public Controller(ServiceDb service) {
        this.service=service;
    }

    //Создание профиля
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UsersColumn users) {
        try {
            service.createAccount(users.getNickname(), users.getPassword_us());
            return ResponseEntity.status(HttpStatus.CREATED).body("Пользователь создан");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //создание поста
    public static class PostRequest{
        public int userid;
        public String content;
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody PostRequest request) {
        try {
            service.createPost(request.userid, request.content);
            return ResponseEntity.status(HttpStatus.CREATED).body("Пост создан");
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //лайк
    @PostMapping("/post/{postId}/likes")
    public ResponseEntity<String>  likePost(@PathVariable int postId) {
        try{
            service.likePost(postId);
            return ResponseEntity.ok("Лайк");
        } catch (RuntimeException e ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //имя
    @PutMapping("{userId}/name")
    public ResponseEntity<String> addName(@PathVariable int userId, @RequestBody String name) {
        try{
            service.addName(userId, name);
            return ResponseEntity.ok("Имя пользователя обновлено");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //фамилия
    @PutMapping("{userId}/lastname")
    public ResponseEntity<String> addLastName(@PathVariable int userId, @RequestBody String lastName) {
        try{
            service.addLastName(userId, lastName);
            return ResponseEntity.ok("Фамилия пользователя обновлена");

        } catch (RuntimeException e ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //аватарка
    @PostMapping("{userId}/avatar")
    public ResponseEntity<String> addAvatar(@PathVariable int userId, @RequestParam("file") MultipartFile file){
        try{
            service.addAvatar(userId, file);
            return ResponseEntity.ok("Аватар обновлен");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //показ постов
    @GetMapping("/posts")
    public ResponseEntity<List<PostsColumn>> getAllPost() {
        try {
            List<PostsColumn> posts =service.getAllPosts();
            return ResponseEntity.ok(posts);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}

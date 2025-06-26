package aplicationpackage.databaseApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryWebPosts extends CrudRepository<PostsColumn, Integer> {
    @Override
    List<PostsColumn> findAll();
}

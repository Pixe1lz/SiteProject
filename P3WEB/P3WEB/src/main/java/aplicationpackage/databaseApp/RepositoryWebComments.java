package aplicationpackage.databaseApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryWebComments extends CrudRepository<CommentsColumn, Integer> {
    List<CommentsColumn> findByUserId(Long userId);
}

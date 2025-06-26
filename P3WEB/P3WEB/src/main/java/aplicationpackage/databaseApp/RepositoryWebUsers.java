package aplicationpackage.databaseApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryWebUsers extends CrudRepository<UsersColumn, Integer> {
    Optional<UsersColumn> findByUsersId(int usersId);
}

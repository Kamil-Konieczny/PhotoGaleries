package pl.kamil.PhotoGaleries.DBConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamil.PhotoGaleries.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
    User findByName(String user_name);
}

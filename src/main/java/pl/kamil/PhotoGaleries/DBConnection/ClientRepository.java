package pl.kamil.PhotoGaleries.DBConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamil.PhotoGaleries.Entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByLogin(String login);
}

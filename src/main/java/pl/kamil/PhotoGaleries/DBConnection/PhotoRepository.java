package pl.kamil.PhotoGaleries.DBConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamil.PhotoGaleries.Entities.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Long> {

}

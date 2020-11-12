package pl.kamil.PhotoGaleries.DBConnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kamil.PhotoGaleries.Entities.Gallery;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery,Long>{
}

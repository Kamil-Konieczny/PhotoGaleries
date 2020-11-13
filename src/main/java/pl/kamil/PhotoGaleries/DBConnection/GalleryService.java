package pl.kamil.PhotoGaleries.DBConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamil.PhotoGaleries.Entities.Gallery;

@Service
public class GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    public void saveGallery(Gallery gallery)
    {
        galleryRepository.save(gallery);
    }
    public void update(Gallery gallery)
    {
        galleryRepository.saveAndFlush(gallery);
    }
}

package pl.kamil.PhotoGaleries.DBConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamil.PhotoGaleries.Entities.Photo;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public void savePhoto(Photo photo)
    {
        photoRepository.save(photo);
    }
}

package pl.kamil.PhotoGaleries.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Galeries")
public class Gallery {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
Long gallery_id;

@Column
String galleryName;

    public Long getGallery_id() {
        return gallery_id;
    }

    public void setGallery_id(Long gallery_id) {
        this.gallery_id = gallery_id;
    }


    public String getGalleryName() {
        return galleryName;
    }

    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
    }
    @OneToOne(mappedBy="gallery")
    private Client client;
}

package pl.kamil.PhotoGaleries.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Galleries")
public class Gallery implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long gallery_id;
    private String galleryName;

    @OneToOne(mappedBy="gallery")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="gallery_photos",
            joinColumns = @JoinColumn(name="id_gallery"),
            inverseJoinColumns = @JoinColumn(name="id_photo", unique=true))
    private List<Photo> photos = new ArrayList<>();

    public Gallery() {

    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Gallery(String galleryName) {
        this.galleryName = galleryName;

    }
    public void addPhoto(Photo photo)
    {
        photos.add(photo);
    }
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

}

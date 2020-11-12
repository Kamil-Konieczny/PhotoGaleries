package pl.kamil.PhotoGaleries.Entities;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

@Entity
@Table(name = "Photos")
public class Photo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photo_id;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String photo;
    @Transient
    private MultipartFile file;
    private String photoName;

    @ManyToOne
    private Gallery gallery;

    public Photo(String photoName, MultipartFile file) {
        this.photoName = photoName;
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a valid file");
        }
        try {
            photo = (Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    public Photo() {
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public Long getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(Long photo_id) {
        this.photo_id = photo_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }
}

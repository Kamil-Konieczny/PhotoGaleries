package pl.kamil.PhotoGaleries.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;
    private String login;
    private String password;
    private String name;
    private String role ;

    public User() {
    }

    public User(String login, String password, String client_name, String role) {
        this.login = login;
        this.password = password;
        this.name = client_name;
        this.role = role;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    @Override
    public String toString() {
        return "User{" +
                "client_id=" + client_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", user_name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", gallery=" + gallery +
                '}';
    }
}

package pl.kamil.PhotoGaleries.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Clients")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cutomer_id;
    @Column
    String login;
    @Column
    String password;
    @Column
    String client_name;
    @Column
    String role ;

    public Client() {
    }

    public Client(String login, String password, String client_name, String role) {
        this.login = login;
        this.password = password;
        this.client_name = client_name;
        this.role = role;
    }

    public Long getCutomer_id() {
        return cutomer_id;
    }

    public void setCutomer_id(Long cutomer_id) {
        this.cutomer_id = cutomer_id;
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

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
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
}

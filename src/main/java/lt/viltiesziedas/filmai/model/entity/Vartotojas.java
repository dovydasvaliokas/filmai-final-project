package lt.viltiesziedas.filmai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Vartotojas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @JsonIgnore
    @OneToMany(mappedBy = "vartotojoKomentaras")
    private Set<Komentaras> vartotojoKomentarai;

    public Vartotojas() {
    }

    public Vartotojas(int id, String username, Set<Komentaras> vartotojoKomentarai) {
        this.id = id;
        this.username = username;
        this.vartotojoKomentarai = vartotojoKomentarai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Komentaras> getVartotojoKomentarai() {
        return vartotojoKomentarai;
    }

    public void setVartotojoKomentarai(Set<Komentaras> vartotojoKomentarai) {
        this.vartotojoKomentarai = vartotojoKomentarai;
    }

    @Override
    public String toString() {
        return "Vartotojas{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", vartotojoKomentarai=" + vartotojoKomentarai +
                '}';
    }
}


package lt.viltiesziedas.filmai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Filmas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String pavadinimas;
    private short metai;
    private float imdb_rating;
    private short trukme_min;

    @Column(length = 3000, name = "aprasymas")
    private String aprasymas;

    @ManyToOne
    @JoinColumn(name = "rezisieriaus_id")
    private Rezisierius filmoRezisierius;

    @ManyToOne
    @JoinColumn(name = "zanro_id")
    private Zanras filmoZanras;

    public Filmas() {
    }

    public Filmas(int id, String pavadinimas, short metai, float imdb_rating, short trukme_min, String aprasymas, Rezisierius filmoRezisierius, Zanras filmoZanras) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.metai = metai;
        this.imdb_rating = imdb_rating;
        this.trukme_min = trukme_min;
        this.aprasymas = aprasymas;
        this.filmoRezisierius = filmoRezisierius;
        this.filmoZanras = filmoZanras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public short getMetai() {
        return metai;
    }

    public void setMetai(short metai) {
        this.metai = metai;
    }

    public float getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(float imdb_rating) {
        this.imdb_rating = imdb_rating;
    }

    public short getTrukme_min() {
        return trukme_min;
    }

    public void setTrukme_min(short trukme_min) {
        this.trukme_min = trukme_min;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public Rezisierius getFilmoRezisierius() {
        return filmoRezisierius;
    }

    public void setFilmoRezisierius(Rezisierius filmoRezisierius) {
        this.filmoRezisierius = filmoRezisierius;
    }

    public Zanras getFilmoZanras() {
        return filmoZanras;
    }

    public void setFilmoZanras(Zanras filmoZanras) {
        this.filmoZanras = filmoZanras;
    }

    @Override
    public String toString() {
        return "Filmas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", metai=" + metai +
                ", imdb_rating=" + imdb_rating +
                ", trukme_min=" + trukme_min +
                ", aprasymas='" + aprasymas + '\'' +
                ", filmoRezisierius=" + filmoRezisierius +
                ", filmoZanras=" + filmoZanras +
                '}';
    }
}

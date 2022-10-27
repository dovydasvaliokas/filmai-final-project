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
    private float imdbRating;
    private short trukmeMin;

    @Column(length = 3000, name = "aprasymas")
    private String aprasymas;

    @ManyToOne
    @JoinColumn(name = "rezisieriaus_id")
    private Rezisierius filmoRezisierius;

    @JsonIgnore
    @OneToMany(mappedBy = "komentarasFilmui")
    private Set<Komentaras> filmoKomentarai;

    @ManyToMany
    @JoinTable(
            name = "filmo_zanrai",
            joinColumns = @JoinColumn(name = "filmo_id"),
            inverseJoinColumns = @JoinColumn(name = "zanro_id")
    )
    private Set<Zanras> filmoZanrai;

    public Filmas() {
    }

    public Filmas(int id, String pavadinimas, short metai, float imdbRating, short trukmeMin, String aprasymas, Rezisierius filmoRezisierius, Set<Zanras> filmoZanrai, Set<Komentaras> filmoKomentarai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.metai = metai;
        this.imdbRating = imdbRating;
        this.trukmeMin = trukmeMin;
        this.aprasymas = aprasymas;
        this.filmoRezisierius = filmoRezisierius;
        this.filmoZanrai = filmoZanrai;
        this.filmoKomentarai = filmoKomentarai;
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

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public short getTrukmeMin() {
        return trukmeMin;
    }

    public void setTrukmeMin(short trukmeMin) {
        this.trukmeMin = trukmeMin;
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

    public Set<Zanras> getFilmoZanrai() {
        return filmoZanrai;
    }

    public void setFilmoZanrai(Set<Zanras> filmoZanrai) {
        this.filmoZanrai = filmoZanrai;
    }

    public Set<Komentaras> getFilmoKomentarai() {
        return filmoKomentarai;
    }

    public void setFilmoKomentarai(Set<Komentaras> filmoKomentarai) {
        this.filmoKomentarai = filmoKomentarai;
    }

    @Override
    public String toString() {
        return "Filmas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", metai=" + metai +
                ", imdbRating=" + imdbRating +
                ", trukmeMin=" + trukmeMin +
                ", aprasymas='" + aprasymas + '\'' +
                '}';
    }
    //komentaras toString ar reikes, ar nesibugins
}

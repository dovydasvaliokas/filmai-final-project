package lt.viltiesziedas.filmai.model.entity;

import javax.persistence.*;

@Entity
public class Komentaras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 3000)
    private String komentaras;

    @ManyToOne
    @JoinColumn(name = "vartotojo_id")
    private Vartotojas vartotojoKomentaras;

    @ManyToOne
    @JoinColumn(name = "filmo_id")
    private Filmas komentarasFilmui;

    public Komentaras() {
    }

    public Komentaras(int id, String komentaras, Vartotojas vartotojoKomentaras, Filmas komentarasFilmui) {
        this.id = id;
        this.komentaras = komentaras;
        this.vartotojoKomentaras = vartotojoKomentaras;
        this.komentarasFilmui = komentarasFilmui;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKomentaras() {
        return komentaras;
    }

    public void setKomentaras(String komentaras) {
        this.komentaras = komentaras;
    }

    public Vartotojas getVartotojoKomentaras() {
        return vartotojoKomentaras;
    }

    public void setVartotojoKomentaras(Vartotojas vartotojoKomentaras) {
        this.vartotojoKomentaras = vartotojoKomentaras;
    }

    public Filmas getKomentarasFilmui() {
        return komentarasFilmui;
    }

    public void setKomentarasFilmui(Filmas komentarasFilmui) {
        this.komentarasFilmui = komentarasFilmui;
    }

    @Override
    public String toString() {
        return "Komentaras{" +
                "id=" + id +
                ", komentaras='" + komentaras + '\'' +
                ", vartotojoKomentaras=" + vartotojoKomentaras +
                ", komentarasFilmui=" + komentarasFilmui +
                '}';
    }
}

package lt.viltiesziedas.filmai.model.entity;

import javax.persistence.*;

@Entity
public class Komentaras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 3000)
    private String tekstas;

    @ManyToOne
    @JoinColumn(name = "vartotojo_id")
    private Vartotojas vartotojoKomentaras;

    @ManyToOne
    @JoinColumn(name = "filmo_id")
    private Filmas komentarasFilmui;

    public Komentaras() {
    }

    public Komentaras(int id, String tekstas, Vartotojas vartotojoKomentaras, Filmas komentarasFilmui) {
        this.id = id;
        this.tekstas = tekstas;
        this.vartotojoKomentaras = vartotojoKomentaras;
        this.komentarasFilmui = komentarasFilmui;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTekstas() {
        return tekstas;
    }

    public void setTekstas(String tekstas) {
        this.tekstas = tekstas;
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
                ", komentaras='" + tekstas + '\'' +
                ", vartotojoKomentaras=" + vartotojoKomentaras +
                ", komentarasFilmui=" + komentarasFilmui +
                '}';
    }
}

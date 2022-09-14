package lt.viltiesziedas.filmai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Zanras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pavadinimas;

    @JsonIgnore
    @OneToMany(mappedBy = "filmoZanras")
    private Set<Filmas> zanroFilmai;

    public Zanras() {
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

    public Set<Filmas> getZanroFilmai() {
        return zanroFilmai;
    }

    public void setZanroFilmai(Set<Filmas> zanroFilmai) {
        this.zanroFilmai = zanroFilmai;
    }

    @Override
    public String toString() {
        return "Zanras{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", zanroFilmai=" + zanroFilmai +
                '}';
    }
}

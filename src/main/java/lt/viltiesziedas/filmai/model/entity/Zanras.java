package lt.viltiesziedas.filmai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Zanras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pavadinimas;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "filmo_zanrai",
            joinColumns = @JoinColumn(name = "zanro_id"),
            inverseJoinColumns =  @JoinColumn(name = "filmo_id")
    )
    private Set<Filmas> zanroFilmai;


    public Zanras() {
    }

    public Zanras(int id, String pavadinimas, Set<Filmas> zanroFilmai) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.zanroFilmai = zanroFilmai;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zanras zanras = (Zanras) o;
        return id == zanras.id && Objects.equals(pavadinimas, zanras.pavadinimas) && Objects.equals(zanroFilmai, zanras.zanroFilmai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pavadinimas, zanroFilmai);
    }
}

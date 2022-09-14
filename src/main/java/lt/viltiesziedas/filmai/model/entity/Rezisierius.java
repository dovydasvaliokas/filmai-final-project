package lt.viltiesziedas.filmai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Rezisierius {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String vardas_pavarde;

    @JsonIgnore
    @OneToMany(mappedBy = "filmoRezisierius")
    private Set<Filmas> rezisieriausFilmai;

    public Rezisierius() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas_pavarde() {
        return vardas_pavarde;
    }

    public void setVardas_pavarde(String vardas_pavarde) {
        this.vardas_pavarde = vardas_pavarde;
    }

    public Set<Filmas> getRezisieriausFilmai() {
        return rezisieriausFilmai;
    }

    public void setRezisieriausFilmai(Set<Filmas> rezisieriausFilmai) {
        this.rezisieriausFilmai = rezisieriausFilmai;
    }

    @Override
    public String toString() {
        return "Rezisierius{" +
                "id=" + id +
                ", vardas_pavarde='" + vardas_pavarde + '\'' +
                ", rezisieriausFilmai=" + rezisieriausFilmai +
                '}';
    }
}

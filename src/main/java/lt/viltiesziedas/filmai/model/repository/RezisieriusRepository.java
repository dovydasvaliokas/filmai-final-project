package lt.viltiesziedas.filmai.model.repository;

import lt.viltiesziedas.filmai.model.entity.Rezisierius;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RezisieriusRepository extends JpaRepository<Rezisierius, Integer> {

    Rezisierius findById(int id);
    Rezisierius findByVardasPavarde(String vardas_pavarde);
    List<Rezisierius> findAll();

}

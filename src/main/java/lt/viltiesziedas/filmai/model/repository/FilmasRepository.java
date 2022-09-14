package lt.viltiesziedas.filmai.model.repository;

import lt.viltiesziedas.filmai.model.entity.Filmas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmasRepository extends JpaRepository<Filmas, Integer> {

    Filmas findByPavadinimas(String pavadinimas);
    List<Filmas> findByMetai(short metai);
    List<Filmas> findByRezisierius(String filmoRezisierius);
    List<Filmas> findByZanras(String filmoZanras);
    List<Filmas> findAll();

}

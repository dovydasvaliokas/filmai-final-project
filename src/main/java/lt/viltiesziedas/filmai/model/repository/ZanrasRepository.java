package lt.viltiesziedas.filmai.model.repository;

import lt.viltiesziedas.filmai.model.entity.Zanras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZanrasRepository extends JpaRepository<Zanras, Integer> {

    Zanras findById(int id);
    Zanras findByPavadinimas(String pavadinimas);
    List<Zanras> findAll();

}

package cat.itb.projecte.repository;

import cat.itb.projecte.controlador.Empleat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleatRepository extends JpaRepository<Empleat,Integer> {
}

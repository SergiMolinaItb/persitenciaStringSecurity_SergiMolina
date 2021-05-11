package cat.itb.projecte.repository;

import cat.itb.projecte.controlador.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuari,String> {
}

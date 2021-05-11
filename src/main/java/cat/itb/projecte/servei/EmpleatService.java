package cat.itb.projecte.servei;

import cat.itb.projecte.controlador.Empleat;
import cat.itb.projecte.repository.EmpleatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class EmpleatService {

    @Autowired
    private EmpleatRepository repositori;

    public void afegir(Empleat e) {
        repositori.save(e);
    }
    public Iterable<Empleat> llistat() {
        return repositori.findAll();
    }
    public List<Empleat> llistatOrdenatPerNom(){
        List<Empleat> empleats = repositori.findAll();
        Collections.sort(empleats, Comparator.comparing (Empleat::getNom));
        return empleats;
    }
    public Empleat consultaPerId(int id){
        return repositori.findById(id).orElse(null);
    }
    public void eliminarPerId(int id){
        repositori.deleteById(id);
    }
    public void substituir(Empleat e){
        repositori.save(e);
    }

    @PostConstruct
    public void init() {
        repositori.saveAll (
                Arrays.asList(
                        new Empleat(1, "Sergi Molina", "sergi@itb.cat", "636322121" ,true),
                        new Empleat(2, "Alberto Vila", "alberto@itb.cat", "699876543", false),
                        new Empleat(3, "Robert López", "robert@bbc.com", "123456789", false)
                )
        );
    }
}

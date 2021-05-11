package cat.itb.projecte.servei;

import cat.itb.projecte.controlador.Usuari;
import cat.itb.projecte.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository usuaris;

    public Usuari consultaPerId(String s){
        return usuaris.findById(s).orElse(null);
    }

    public void afegir(Usuari e) {
        usuaris.save(e);
    }

    public Iterable<Usuari> llistat() {
        return usuaris.findAll();
    }

    @PostConstruct
    public void init() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuaris.saveAll (
                Arrays.asList(
                        new Usuari("Sergi", passwordEncoder.encode ("12345"), "ADMIN"),
                        new Usuari("Marc", passwordEncoder.encode ("12345"), "USER"),
                        new Usuari("Agus", passwordEncoder.encode ("Solsona"), "USER")
                )
        );
    }
}

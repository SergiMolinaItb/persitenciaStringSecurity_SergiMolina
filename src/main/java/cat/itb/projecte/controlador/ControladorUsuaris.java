package cat.itb.projecte.controlador;

import cat.itb.projecte.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorUsuaris {

    @Autowired
    private UserService servei;

    @GetMapping("/register")
    public String afegirUser(Model m){
        m.addAttribute("registerForm",new Usuari());
        return "register";
    }

    @PostMapping("register/submit")
    public String afegirSubmit(@ModelAttribute("registerForm") Usuari usu){
        servei.afegir(new Usuari(usu.getUsername(), passwordEncoder.encode(usu.getPassword()),"USER"));
        return "redirect:/login";
    }

    public BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
}

package cat.itb.projecte.controlador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuari implements Serializable{
    @Id
    private String username;
    private String password;
    private String rol;
}

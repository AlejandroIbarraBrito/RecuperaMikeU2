package mx.edu.utez.viajes.controllers.usuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.usuario.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String correo;
    private String fechaN;

    public Usuario parseToUsuario() {
        return new Usuario(
                getId(),
                getNombre(),
                getCorreo(),
                getFechaN(),
                null
        );
    }
}

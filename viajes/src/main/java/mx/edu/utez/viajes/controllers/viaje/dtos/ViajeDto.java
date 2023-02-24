package mx.edu.utez.viajes.controllers.viaje.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.destino.Destino;
import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.models.viaje.Viaje;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ViajeDto {
    public Long id;
    private Usuario usuario;
    private Destino destino;
    private String fechaS;
    private String fechaR;

    public Viaje parseToViaje() {
        return new Viaje(
                getId(),
                getUsuario(),
                getDestino(),
                getFechaS(),
                getFechaR()
        );
    }
}

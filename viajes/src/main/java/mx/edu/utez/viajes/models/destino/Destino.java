package mx.edu.utez.viajes.models.destino;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.models.viaje.Viaje;

import javax.persistence.*;

@Entity
@Table(name = "destinos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Double calificacion;
    private Boolean disponibilidad;
    @OneToOne(mappedBy = "destino")
    @JsonIgnore
    private Viaje viaje;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Usuario usuario;
}

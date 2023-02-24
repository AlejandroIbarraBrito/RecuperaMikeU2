package mx.edu.utez.viajes.models.viaje;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.destino.Destino;
import mx.edu.utez.viajes.models.usuario.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "viajes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name = "destino_id", referencedColumnName = "id")
    private Destino destino;
    private String fechaS;
    private String fechaR;

    @Override
    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", destino=" + destino +
                ", fechaS='" + fechaS + '\'' +
                ", fechaR='" + fechaR + '\'' +
                '}';
    }
}

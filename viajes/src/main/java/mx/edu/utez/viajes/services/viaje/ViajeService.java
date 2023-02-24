package mx.edu.utez.viajes.services.viaje;

import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.models.viaje.Viaje;
import mx.edu.utez.viajes.models.viaje.ViajeRepository;
import mx.edu.utez.viajes.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViajeService {
    @Autowired
    private ViajeRepository repository;

    public Response getAll() {
        return new Response<List<Viaje>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public Response getOne(long id) {
        return new Response<Object>(
                this.repository.findById(id),
                false,
                200,
                "OK"
        );
    }

    public Response insert(Viaje viaje) {
        System.out.println("Aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        System.out.println(viaje);
        return new Response(
                this.repository.saveAndFlush(viaje),
                false,
                200,
                "Usuario registrado correctamente"
        );
    }

    public Response update(Viaje viaje) {
        if (this.repository.existsById(viaje.getId()))
            return new Response(
                    this.repository.saveAndFlush(viaje),
                    false,
                    200,
                    "Viaje actualizado correctamente"
            );
        return new Response(
                null,
                true,
                400,
                "No existe este viaje"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Viaje eliminado correctamente");
        }
        return new Response(
                null,
                true,
                400,
                "No existe este viaje"
        );
    }
}

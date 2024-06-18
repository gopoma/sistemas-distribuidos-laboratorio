package server.Ingeniero.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;
import server.Ingeniero.Model.CreateIngeniero;
import server.Ingeniero.Model.IngProj;
import server.Ingeniero.Model.Ingeniero;
import server.Ingeniero.Model.UpdateIngeniero;
import server.Ingeniero.Repositories.IngenieroRepository;
import server.Proyecto.Model.Proyecto;
import server.Proyecto.Repositories.ProyectoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngenieroServices {
    private final IngenieroRepository ingenieroRepository;
    private final ProyectoRepository proyectoRepository;

    public List<Ingeniero> getIngenieros() {
        return ingenieroRepository.findAll();
    }

    public Optional<Ingeniero> getIngenieroById(Integer id) {
        return ingenieroRepository.findById(id);
    }

    public List<IngProj> getIngenieroProject(Integer id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Proyecto no encontrado")
        );

        List<Ingeniero> ingenieros = ingenieroRepository.findAllByidProyecto(id);
        return ingenieros.stream()
                .map(ingeniero -> new IngProj(ingeniero, proyecto))
                .collect(Collectors.toList());
    }

    public Ingeniero createIngeniero(CreateIngeniero ingeniero) {
        Ingeniero ing = Ingeniero.builder()
                .idIngeniero(null)
                .Especialidad(ingeniero.Especialidad())
                .Cargo(ingeniero.Cargo())
                .idProyecto(AggregateReference.to(ingeniero.idProyecto()))
                .build();
        return ingenieroRepository.save(ing);
    }

    public Ingeniero updateIngeniero(UpdateIngeniero ing) {
        Ingeniero old = ingenieroRepository.findById(ing.idIngeniero()).orElse(null);
        Ingeniero newIng = Ingeniero.builder()
                .idIngeniero(ing.idIngeniero())
                .Especialidad(ing.Especialidad())
                .Cargo(ing.Cargo())
                .idProyecto(AggregateReference.to(ing.idProyecto()))
                .build();

        return ingenieroRepository.save(newIng);
    }

    public void deleteIngeniero(Integer id) {
        ingenieroRepository.deleteById(id);
    }
}

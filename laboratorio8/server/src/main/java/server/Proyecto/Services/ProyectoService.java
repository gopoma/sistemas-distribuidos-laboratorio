package server.Proyecto.Services;

import lombok.RequiredArgsConstructor;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;
import server.Departamento.Model.Departamento;
import server.Departamento.Repositories.DepartamentoRepository;
import server.Proyecto.Model.Proyecto;
import server.Proyecto.Model.dto.CreateProject;
import server.Proyecto.Model.dto.ProyectoDep;
import server.Proyecto.Model.dto.UpdateProject;
import server.Proyecto.Repositories.ProyectoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;
    private final DepartamentoRepository departamentoRepository;

    public List<Proyecto> getProyectos() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> getProyectoById(Integer id) {
        return proyectoRepository.findById(id);
    }

    public List<ProyectoDep> getProyectoDep(Integer id) {
        Departamento departamento = departamentoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Departamento no encontrado")
        );
        List<Proyecto> proyectos = proyectoRepository.findAllByidDepartamentos(id);

        return proyectos.stream()
                .map(proyecto -> new ProyectoDep(proyecto, departamento))
                .collect(Collectors.toList());
    }

    public Proyecto createProyecto(CreateProject proyecto) {
        Proyecto project = Proyecto.builder()
                .idProyecto(null)
                .Nombre(proyecto.Nombre())
                .fecInicio(proyecto.Fec_Inicio())
                .fecFinal(proyecto.Fec_Final())
                .idDepartamentos(AggregateReference.to(proyecto.idDepartamentos()))
                .build();
        return proyectoRepository.save(project);
    }

    public Proyecto updateProyecto(UpdateProject proyecto) {
        Proyecto old = proyectoRepository.findById(proyecto.idProyecto()).orElse(null);
        Proyecto newProyecto = Proyecto.builder()
                .idProyecto(proyecto.idProyecto())
                .Nombre(proyecto.Nombre())
                .fecInicio(proyecto.Fec_Inicio())
                .fecFinal(proyecto.Fec_Final())
                .idDepartamentos(AggregateReference.to(proyecto.idDepartamentos()))
                .build();

        return proyectoRepository.save(newProyecto);
    }

    public void deleteProyecto(Integer id) {
        proyectoRepository.deleteById(id);
    }


}

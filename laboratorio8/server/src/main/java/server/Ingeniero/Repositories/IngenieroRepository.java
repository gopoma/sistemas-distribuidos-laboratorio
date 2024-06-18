package server.Ingeniero.Repositories;

import org.springframework.data.repository.ListCrudRepository;
import server.Ingeniero.Model.Ingeniero;
import server.Proyecto.Model.Proyecto;

import java.util.List;

public interface DepartamentoRepository extends ListCrudRepository<Proyecto, Integer> {
    List<Ingeniero> findAllByProject(Integer id);
}

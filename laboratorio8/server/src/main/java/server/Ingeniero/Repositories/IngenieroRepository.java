package server.Ingeniero.Repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import server.Ingeniero.Model.Ingeniero;

import java.util.List;

@Repository
public interface IngenieroRepository extends ListCrudRepository<Ingeniero, Integer> {
    List<Ingeniero> findAllByidProyecto(Integer id);
}

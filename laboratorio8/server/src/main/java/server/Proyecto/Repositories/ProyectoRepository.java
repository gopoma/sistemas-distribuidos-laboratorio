package server.Proyecto.Repositories;

import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import server.Proyecto.Model.Proyecto;

import java.util.List;

@Repository
public interface ProyectoRepository extends ListCrudRepository<Proyecto, Integer>{
    List<Proyecto> findAllByidDepartamentos(Integer id);
}


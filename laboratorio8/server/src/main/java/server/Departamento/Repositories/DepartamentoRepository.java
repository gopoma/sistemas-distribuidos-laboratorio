package server.Departamento.Repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import server.Departamento.Model.Departamento;

@Repository
public interface DepartamentoRepository extends ListCrudRepository<Departamento, Integer>{
}

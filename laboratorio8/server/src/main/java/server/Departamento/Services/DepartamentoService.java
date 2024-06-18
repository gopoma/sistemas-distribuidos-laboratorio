package server.Departamento.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import server.Departamento.Model.Departamento;
import server.Departamento.Repositories.DepartamentoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;

    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento getDepById(Integer id) {
        return departamentoRepository.findById(id).get();
    }

    public Departamento createDepartamento(Departamento dep) {
        return departamentoRepository.save(dep);
    }

    public Departamento updateDepartamento(Departamento dep) {
        return  departamentoRepository.save(dep);
    }

    public void deleteDepartamento(Integer id) {
        departamentoRepository.deleteById(id);
    }
}

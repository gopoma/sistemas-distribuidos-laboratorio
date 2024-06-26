package server.Departamento.Controllers;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import server.Departamento.Model.Departamento;
import server.Departamento.Services.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("/departamento")
@RequiredArgsConstructor
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return  departamentoService.getAllDepartamentos();
    }

    @GetMapping("/{id}")
    public Departamento getDepartamentoById(@PathVariable("id") Integer id) {
        return  departamentoService.getDepById(id);
    }

    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        return  departamentoService.createDepartamento(departamento);
    }

    @PutMapping
    public Departamento updateDepartamento(@RequestBody Departamento departamento) {
        return  departamentoService.updateDepartamento(departamento);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartamento(@PathVariable("id") Integer id) {
        departamentoService.deleteDepartamento(id);
    }
}

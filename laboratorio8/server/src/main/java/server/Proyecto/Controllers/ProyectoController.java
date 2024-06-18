package server.Proyecto.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.Proyecto.Model.Proyecto;
import server.Proyecto.Model.dto.CreateProject;
import server.Proyecto.Model.dto.ProyectoDep;
import server.Proyecto.Model.dto.UpdateProject;
import server.Proyecto.Services.ProyectoService;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@RequiredArgsConstructor
public class ProyectoController {
    private final ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> getAll() {
        return proyectoService.getProyectos();
    }

    @GetMapping("/{id}")
    public Proyecto getProjectById(@PathVariable("id") Integer id) {
        return proyectoService.getProyectoById(id).orElse(null);
    }

    @GetMapping("/{id}/departamento")
    public  List<ProyectoDep> getProjectByDep(@PathVariable("id") Integer id) {
        return proyectoService.getProyectoDep(id);
    }

    @PostMapping
    public Proyecto createProyecto(@RequestBody CreateProject proyecto) {
        return proyectoService.createProyecto(proyecto);
    }

    @PutMapping
    public Proyecto updateProyecto(@RequestBody UpdateProject proyecto) {
        return proyectoService.updateProyecto(proyecto);
    }

    @DeleteMapping("/{id}")
    public void deleteProyecto(@PathVariable("id") Integer id) {
        proyectoService.deleteProyecto(id);
    }

}

package server.Ingeniero.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.Ingeniero.Model.CreateIngeniero;
import server.Ingeniero.Model.IngProj;
import server.Ingeniero.Model.Ingeniero;
import server.Ingeniero.Model.UpdateIngeniero;
import server.Ingeniero.Services.IngenieroServices;

import java.util.List;

@RestController
@RequestMapping("/ingeniero")
@RequiredArgsConstructor
public class IngenieroController {
    private final IngenieroServices ingenieroServices;

    @GetMapping
    public List<Ingeniero> getAll() {
        return ingenieroServices.getIngenieros();
    }

    @GetMapping("/{id}")
    public Ingeniero getIngenieroById(@PathVariable("id") Integer id) {
        return ingenieroServices.getIngenieroById(id).orElse(null);
    }

    @GetMapping("/{id}/proyecto")
    public  List<IngProj> getIngByProject(@PathVariable("id") Integer id) {
        return ingenieroServices.getIngenieroProject(id);
    }

    @PostMapping
    public Ingeniero createIngeniero(@RequestBody CreateIngeniero ing) {
        return ingenieroServices.createIngeniero(ing);
    }

    @PutMapping
    public Ingeniero updateIngeniero(@RequestBody UpdateIngeniero ing) {
        return ingenieroServices.updateIngeniero(ing);
    }

    @DeleteMapping("/{id}")
    public void deleteIngeniero(@PathVariable("id") Integer id) {
        ingenieroServices.deleteIngeniero(id);
    }
}

package server.Ingeniero.Model;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import server.Proyecto.Model.Proyecto;

public record CreateIngeniero(String Especialidad,
                              String Cargo,
                              Integer idProyecto) {
}

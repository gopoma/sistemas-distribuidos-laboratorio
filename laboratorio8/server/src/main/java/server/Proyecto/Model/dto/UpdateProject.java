package server.Proyecto.Model.dto;

import java.time.LocalDate;
public record UpdateProject(Integer idProyecto,
                            String Nombre,
                            LocalDate Fec_Inicio,
                            LocalDate Fec_Final,
                            Integer idDepartamentos) {
}

package server.Proyecto.Model.dto;

import java.time.LocalDateTime;

public record CreateProyect(String Nombre, LocalDateTime Fec_Inicio, LocalDateTime Fec_Final, Integer idDepartamentos) {
}

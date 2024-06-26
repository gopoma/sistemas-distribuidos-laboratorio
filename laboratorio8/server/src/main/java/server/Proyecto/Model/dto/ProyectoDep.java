package server.Proyecto.Model.dto;

import server.Departamento.Model.Departamento;
import server.Proyecto.Model.Proyecto;

public record ProyectoDep(Proyecto proyecto, Departamento departamento) {
}

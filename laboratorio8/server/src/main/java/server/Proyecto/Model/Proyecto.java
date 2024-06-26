package server.Proyecto.Model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import server.Departamento.Model.Departamento;

import java.time.LocalDate;

@Table("Proyecto")
public record Proyecto(@Id @Column("idProyecto") Integer idProyecto,
                       @Column("Nombre") String Nombre,
                       @Column("Fec_Inicio") LocalDate fecInicio,
                       @Column("Fec_Final") LocalDate fecFinal,
                       @Column("idDepartamentos") AggregateReference<Departamento, Integer> idDepartamentos) {
    @Builder public Proyecto{}

}

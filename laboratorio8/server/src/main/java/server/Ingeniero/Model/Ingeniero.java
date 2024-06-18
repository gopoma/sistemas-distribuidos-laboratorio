package server.Ingeniero.Model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import server.Proyecto.Model.Proyecto;

@Table("Ingenieros")
@Builder
public record Ingeniero(@Id @Column("idIngeniero") Integer idIngeniero,
                        @Column("Especialidad") String Especialidad,
                        @Column("Cargo") String Cargo,
                        @Column("idProyecto") AggregateReference<Proyecto, Integer> idProyecto) {
}

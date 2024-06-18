package server.Departamento.Model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Departamento")
@Builder
public record Departamento(@Id @Column("idDepartamentos") Integer idDepartamentos,
                           @Column("Nombre") String nombre,
                           @Column("Telefono") String Telefono,
                           @Column("Fax") String Fax) {
}

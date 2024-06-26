package server.Departamento.Repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import server.Departamento.Model.Departamento;

import java.sql.Types;
import java.util.Map;

@Repository
public class DepartamentoRepositoryCustomImpl implements DepartamentoRepositoryCustom {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    public void init() {
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("InsertarDepartamento")
                .declareParameters(
                        new SqlParameter("p_Nombre", Types.CHAR),
                        new SqlParameter("p_Telefono", Types.VARCHAR),
                        new SqlParameter("p_Fax", Types.VARCHAR),
                        new SqlOutParameter("p_idDepartamentos", Types.INTEGER)
                );
    }

    @Override
    public Departamento insertarDepartamento(Departamento dep) {
        Map<String, Object> result = simpleJdbcCall.execute(
                dep.nombre(),
                dep.Telefono(),
                dep.Fax()
        );
        System.out.println(result.toString());
        Integer id = (Integer) result.get("p_idDepartamentos");
        Departamento dep2 = Departamento.builder()
                .idDepartamentos(id)
                .nombre(dep.nombre())
                .Telefono(dep.Telefono())
                .Fax(dep.Fax())
                .build();
        return dep2;
    }
}
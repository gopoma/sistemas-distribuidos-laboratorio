package casoEstudio2;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class EjemploTransaccion {
    public static void main(String[] args) {
       Connection conexion = Database.getConnection();
        try {

            conexion.setAutoCommit(false); // Deshabilitar modo auto-commit

            // Ejecutar las operaciones de la transacción
            Statement stmt = conexion.createStatement();

            // Insertar registros
            stmt.executeUpdate("INSERT INTO RESERVAS(pasajero, origen, destino) VALUES('Carlos', 'Barcelona', 'Paris');");
            stmt.executeUpdate("INSERT INTO RESERVAS(pasajero, origen, destino) VALUES('Ana', 'Valencia', 'Berlin');");
            stmt.executeUpdate("INSERT INTO RESERVAS(pasajero, origen, destino) VALUES('Felipe', 'Alicante', 'Madrid')");
            stmt.executeUpdate("INSERT INTO RESERVAS(pasajero, origen, destino) VALUES ('Juan', 'Madrid', 'Dubai')");
            stmt.executeUpdate("INSERT INTO RESERVAS(pasajero, origen, destino) VALUES('Daniel', 'Dubai', 'Sydney')");

            // Actualizar un registro
            stmt.executeUpdate("UPDATE RESERVAS SET destino = 'Melbourne' WHERE pasajero = 'Felipe' AND origen = 'Alicante'");

            // Eliminar un registro (Error en el parametro pasajero)
            //stmt.executeUpdate("DELETE FROM RESERVAS WHERE pasajero = 1 AND origen = 'Barcelona'");

            // Confirmar la transacción
            conexion.commit();

            System.out.println("Transacción exitosa. Todos los cambios se han escrito en la base de datos.");

        } catch (SQLException e) {
            // Revertir la transacción si se produce un error
            try {
                if (conexion != null) {
                    System.out.println("Error en sentencia sql: " + e);
                    System.out.println("Transacción fallida. Realizando rollback.");
                    conexion.rollback();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } finally {
            // Cerrar la conexión
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }
}

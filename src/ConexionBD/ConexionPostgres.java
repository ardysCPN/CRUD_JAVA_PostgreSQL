package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ardys CPN
 */
public class ConexionPostgres {
    private String URL = "jdbc:postgresql://localhost:5432/mercafacil";
    private String USER = "postgres";
    private String PASSWORD = "199211";
    
    private Connection con = null;
    
    public Connection Conexion(){
        
        
        try {
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Error en la conexion "+e.getMessage());
        }
        return con;
    }
    
    public void Desconectar(){
        if (con != null) {
            try {
                con.close();
                System.out.println("Desconectado");
            } catch (SQLException ex) {
                System.out.println("Error al desconectar "+ex.getMessage());
            }
        }
    }
    
}

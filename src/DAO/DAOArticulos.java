package DAO;

import ConexionBD.ConexionPostgres;
import Interfaces.IArticulos;
import Vistas.FormularioCrud;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Articulos;

/**
 *
 * @author Ardys CPN
 */
public class DAOArticulos implements IArticulos{
    
    PreparedStatement pst;
    ResultSet rs;
    ConexionPostgres conexion = new ConexionPostgres();

    @Override
    public List<Articulos> listarDatos() {
        List<Articulos> listarArticulos = new ArrayList<>();
        String sql = "SELECT a.*, c.nombre as nombrecategoria FROM articulos a\n" +
                    "JOIN categorias c ON a.idcategoria = c.idcategoria";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Articulos art = new Articulos();
                art.setCodigo(rs.getInt("codigo"));
                art.setNombreArt(rs.getString("nombre"));
                art.setUnidadMedida(rs.getString("um"));
                art.setExistencias(rs.getInt("existencias"));
                art.setCantMaxima(rs.getInt("cantmax"));
                art.setCantMinima(rs.getInt("canmin"));
                art.setIdCategoria(rs.getInt("idcategoria"));
                art.setNombre(rs.getString("nombrecategoria"));
                
                listarArticulos.add(art); 
            }
            rs.close();
            pst.close();
            
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer los datos "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return listarArticulos;
    }

    @Override
    public boolean InsertarArticulo(Articulos articulo) {
        String sql = "INSERT INTO articulos (nombre, um, existencias, cantmax, canmin, idcategoria)\n" +
                    "VALUES(?,?,?,?,?,?)";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            pst.setString(1, articulo.getNombreArt());
            pst.setString(2, articulo.getUnidadMedida());
            pst.setInt(3, articulo.getExistencias());
            pst.setInt(4, articulo.getCantMaxima());
            pst.setInt(5, articulo.getCantMinima());
            pst.setInt(6, articulo.getIdCategoria());
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al insertar el articulo "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }

    @Override
    public boolean ActualizarArticulo(Articulos articulo) {
        String sql = "UPDATE articulos SET nombre = ?, um = ?, existencias = ?, cantmax = ?,\n" +
                            "canmin = ?, idcategoria = ? WHERE codigo = ?";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            pst.setString(1, articulo.getNombreArt());
            pst.setString(2, articulo.getUnidadMedida());
            pst.setInt(3, articulo.getExistencias());
            pst.setInt(4, articulo.getCantMaxima());
            pst.setInt(5, articulo.getCantMinima());
            pst.setInt(6, articulo.getIdCategoria());
            pst.setLong(7, articulo.getCodigo());
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al actualizar el articulo "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }

    @Override
    public boolean EliminarArticulo(long codigo) {
        String sql = "DELETE from articulos WHERE codigo = ?";
        try {
            pst = conexion.Conexion().prepareStatement(sql);
            pst.setLong(1, codigo);
            
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error al eliminar el articulo "+e.getMessage());
        }finally{
            conexion.Desconectar();
        }
        return false;
    }
    
    //cargamos el JComboBox con las categorias de la base de datos
    public void CargarComboCategorias() {
        try {
            Statement sent = conexion.Conexion().createStatement();
            ResultSet rs = sent.executeQuery("select nombre from categorias");

            while (rs.next()) {
                FormularioCrud.comboCategorias.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            conexion.Desconectar();
        }
    }
    
}

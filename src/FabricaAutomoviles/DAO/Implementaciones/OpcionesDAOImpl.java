package FabricaAutomoviles.DAO.Implementaciones;

import FabricaAutomoviles.DAO.Conexion;
import FabricaAutomoviles.DAO.OpcionesDAO;
import FabricaAutomoviles.Model.Modelo;
import FabricaAutomoviles.Model.Opciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OpcionesDAOImpl extends Conexion implements OpcionesDAO {

    @Override
    public void insert(Opciones opciones) throws Exception {
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement("insert into opciones (Descripcion, Precio) values (?,?)");
            sentencia.setString(1, opciones.getDescripcion());
            sentencia.setInt(2,opciones.getPrecio());

            sentencia.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: En la clase OpcionesDaoImpl, método insert");
            e.printStackTrace();
        }finally {
            this.cerrar();
        }
    }

    @Override
    public void update(Opciones opciones) throws Exception {
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement("UPDATE opciones set descripcion=?, Precio=?  where id = ?");

            sentencia.setString(1, opciones.getDescripcion());
            sentencia.setInt(2,opciones.getPrecio());
            sentencia.setInt(3,opciones.getIdOpcion());

            sentencia.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error: En la clase OpcionesDaoImpl, método update");
            e.printStackTrace();
        }finally {
            this.cerrar();
        }

    }

    @Override
    public void delete(Opciones opciones) throws Exception {
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement("DELETE from opciones where id = ?");
            sentencia.setInt(1, opciones.getIdOpcion());

            sentencia.execute();

        } catch (Exception e) {
            System.out.println("Error: En la clase OpcionesDaoImpl, método delete");
            e.printStackTrace();
        }finally {
            this.cerrar();
        }

    }

    @Override
    public Opciones getQuery(Integer id) throws Exception {
        Opciones opciones = null;
        String consulta ="select * from opciones where id =  "+ id;
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery(consulta);//executeQuery(consulta);

            if (rs.next()) {
                opciones = new Opciones();
                opciones.setIdOpcion(rs.getInt("id"));
                opciones.setPrecio(rs.getInt("Precio"));
                opciones.setDescripcion(rs.getString("Descripcion"));
            }
            rs.close();
            sentencia.close();


        } catch (Exception ex) {
            System.out.println("Error: Clase OpcionesDaoImpl, método getQuery");
            ex.printStackTrace();
        }finally {
            this.cerrar();
        }
        return opciones;

    }
}

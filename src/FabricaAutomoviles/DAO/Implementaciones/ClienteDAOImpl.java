package FabricaAutomoviles.DAO.Implementaciones;

import FabricaAutomoviles.DAO.ClienteDAO;
import FabricaAutomoviles.DAO.Conexion;
import FabricaAutomoviles.Exception.DAOException;
import FabricaAutomoviles.Model.Cliente;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAOImpl extends Conexion implements ClienteDAO  {

    @Override
    public void insert(Cliente cliente) throws DAOException {
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement("insert into cliente (Nombre, Apellido, Cuit) values (?,?,?)");
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2,cliente.getApellido());
            sentencia.setString(3,cliente.getCuit());

            sentencia.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: En la clase ClienteDaoImpl, método insert");
            e.printStackTrace();
        }finally {
            try {
                this.cerrar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement("UPDATE cliente set Nombre=?, Apellido=?, Cuit=?  where id = ?");

            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2,cliente.getApellido());
            sentencia.setString(3,cliente.getCuit());
            sentencia.setInt(4,cliente.getIdCliente());

            sentencia.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: En la clase ClienteDaoImpl, método update");
            e.printStackTrace();
        }finally {
            this.cerrar();
        }


    }

    @Override
    public void delete(Cliente cliente) throws Exception {
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement("DELETE from cliente where id = ?");
            sentencia.setInt(1,cliente.getIdCliente());

            sentencia.execute();

        } catch (Exception e) {
            System.out.println("Error: En la clase ClienteDaoImpl, método delete");
            e.printStackTrace();
        }finally {
            this.cerrar();
        }


    }

    @Override
    public Cliente getQuery(Integer id) throws Exception {
        Cliente cliente = null;
        String consulta = "select * from cliente where id =  " + id;
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery(consulta);

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellido(rs.getString("Apellido"));
                cliente.setCuit(rs.getString("Cuit"));
            }
            rs.close();
            sentencia.close();


        } catch (Exception ex) {
            System.out.println("Error: Clase clienteDaoImpl, método getQuery");
            ex.printStackTrace();
        } finally {
            this.cerrar();
        }
        return cliente;
    }
}

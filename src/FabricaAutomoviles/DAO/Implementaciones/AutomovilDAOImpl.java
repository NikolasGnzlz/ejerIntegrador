package FabricaAutomoviles.DAO.Implementaciones;

import FabricaAutomoviles.DAO.AutomovilDAO;
import FabricaAutomoviles.DAO.Conexion;
import FabricaAutomoviles.Model.Automovil;
import FabricaAutomoviles.Model.Opciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutomovilDAOImpl extends Conexion implements AutomovilDAO {



    @Override
    public void insert(Automovil automovil) throws SQLException {
        String consulta = "insert into automovil (id_Modelo, Nombre_Modelo, Cantidad_Opciones, Precio_Total) values (?,?,?,?)";
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement(consulta,PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setInt(1,automovil.getModelo().getId());
            sentencia.setString(2,automovil.getModelo().getNombre());
            sentencia.setInt(3,automovil.getOpciones().size());
            sentencia.setInt(4,automovil.getPrecioTotal());

            int respuesta = sentencia.executeUpdate();
            System.out.println(respuesta);

            ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()){
                int selectecId = rs.getInt(1);
                automovil.setId(selectecId);
            }

        } catch (Exception e) {
            System.out.println("Error: En la clase AutomovilDaoImpl, método insert");
            e.printStackTrace();
        }finally {
            this.cerrar();
        }
    }



    @Override
    public void update(Automovil automovil) throws SQLException {

        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement("update automovil set id_Modelo=?, Nombre_Modelo=?, Cantidad_Opciones=?, Precio_Total=? where id=?"); //,PreparedStatement.RETURN_GENERATED_KEYS);
            sentencia.setInt(1,automovil.getModelo().getId());
            sentencia.setString(2,automovil.getModelo().getNombre());
            sentencia.setInt(3,automovil.getOpciones().size());
            sentencia.setInt(4,automovil.getPrecioTotal());
            sentencia.setInt(5,automovil.getId());

            sentencia.execute();

        } catch (Exception e) {
            System.out.println("Error: En la clase AutomovilDaoImpl, método update");
            e.printStackTrace();
        }finally {
            this.cerrar();
        }

    }

    @Override
    public void delete(Automovil automovil) throws SQLException {
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement("DELETE from automovil where id = ?");
            sentencia.setInt(1, automovil.getId());

            sentencia.execute();

        } catch (Exception e) {
            System.out.println("Error: En la clase AutomovilDaoImpl, método delete");
            e.printStackTrace();
        }finally {
            this.cerrar();
        }

    }

    @Override
    public Automovil getQuery(Integer id) throws SQLException {
        Automovil automovil = null;
        String consulta = "select * from automovil where id ="+ id;
        try {
            this.conectar();
            PreparedStatement sentencia = this.conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery(consulta);

            if (rs.next()) {
                automovil = new Automovil();
                automovil.setId(rs.getInt("id"));
                automovil.setNombre(rs.getString("Nombre_Modelo"));
                automovil.setPrecioTotal(rs.getInt("Precio_Total"));
            }
            rs.close();
            sentencia.close();
        } catch (Exception ex) {
            System.out.println("Error: Clase AutomovilDaoImpl, método getQuery");
            ex.printStackTrace();
        }finally {
            this.cerrar();
        }
        return automovil;
    }

    @Override
    public List<Automovil> listar() throws SQLException {
            List<Automovil> lista = null;
            try{
                this.conectar();
                PreparedStatement sentencia = this.conexion.prepareStatement("select * from automovil");
                lista = new ArrayList();
                ResultSet rs  = sentencia.executeQuery();
                while (rs.next()){
                    Automovil aut = new Automovil();
                    aut.setId(rs.getInt("id"));
                    aut.setNombre(rs.getString("Nombre_Modelo"));
                    aut.setPrecioTotal(rs.getInt("Precio_Total"));
                    lista.add(aut);
                }
                rs.close();
                sentencia.close();
            }catch (Exception ex) {
                System.out.println("Error: Clase AutomovilDaoImpl, método Listar");
                ex.printStackTrace();
            }finally {
                this.cerrar();
            }

        return lista;
    }


}

package FabricaAutomoviles.DAO.Implementaciones;

import FabricaAutomoviles.DAO.Conexion;
import FabricaAutomoviles.DAO.ModeloDAO;
import FabricaAutomoviles.Model.Modelo;


import java.sql.*;

public class ModeloDAOImpl extends Conexion implements ModeloDAO  {


        @Override
        public void insert(Modelo modelo)  {
            try {
                this.conectar();
                PreparedStatement sentencia = this.conexion.prepareStatement("insert into modelo (Nombre, Precio) values (?,?)");
                sentencia.setString(1, modelo.getNombre());
                sentencia.setInt(2,modelo.getPrecio());

                sentencia.executeUpdate();

            } catch (Exception e) {
                System.out.println("Error: En la clase ModeloDaoImpl, método insert");
                e.printStackTrace();
            }finally {
                try {
                    this.cerrar();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        @Override
        public void update(Modelo modelo)  {
            try {
                this.conectar();
                PreparedStatement sentencia = this.conexion.prepareStatement("UPDATE modelo set Nombre=?, Precio=?  where id = ?");

                sentencia.setString(1, modelo.getNombre());
                sentencia.setInt(2,modelo.getPrecio());
                sentencia.setInt(3,modelo.getId());

                sentencia.executeUpdate();

            } catch (Exception e) {
                System.out.println("Error: En la clase ModeloDaoImpl, método update");
                e.printStackTrace();
            }finally {
                try {
                    this.cerrar();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        @Override
        public void delete(Modelo modelo)  {
            try {
                this.conectar();
                PreparedStatement sentencia = this.conexion.prepareStatement("DELETE from modelo where id = ?");
                sentencia.setInt(1,modelo.getId());

                sentencia.execute();

            } catch (Exception e) {
                System.out.println("Error: En la clase ModeloDaoImpl, método delete");
                e.printStackTrace();
            }finally {
                try {
                    this.cerrar();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


        }

        @Override
        public Modelo getQuery(Integer id) {
            Modelo modelo = null;
            String consulta ="select * from modelo where id =  "+ id;
            try {
                this.conectar();
                PreparedStatement sentencia = this.conexion.prepareStatement(consulta);
                ResultSet rs = sentencia.executeQuery(consulta);//executeQuery(consulta);

                if (rs.next()) {
                    modelo = new Modelo();
                    modelo.setId(rs.getInt("id"));
                    modelo.setPrecio(rs.getInt("Precio"));
                    modelo.setNombre(rs.getString("Nombre"));
                }
                rs.close();
                sentencia.close();


            } catch (Exception ex) {
                System.out.println("Error: Clase ModeloDaoImpl, método getQuery");
                ex.printStackTrace();
            }finally {
                try {
                    this.cerrar();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return modelo;

        }



}

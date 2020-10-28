package FabricaAutomoviles.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

        protected Connection conexion;

        private final static String url = "jdbc:mysql://localhost:3306/fabricadeautos?serverTimezone=UTC";
        private final static String usuario = "root";
        private final static String clave = "";


        public void conectar() throws Exception{
            try{
                conexion = DriverManager.getConnection(url, usuario, clave);
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Conexión exitosa" );
            }catch (Exception e) {
                throw e;
            } //System.out.println("Conexion fallida");
        }

        public void cerrar() throws SQLException {
            if(conexion != null){
                if (!conexion.isClosed()){
                        conexion.close();
                }
            }
        }



}

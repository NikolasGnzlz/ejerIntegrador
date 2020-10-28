package FabricaAutomoviles.DAO;

import FabricaAutomoviles.Model.Automovil;

import java.sql.SQLException;
import java.util.List;

public interface AutomovilDAO {

        public void insert(Automovil automovil) throws SQLException;
        public void update(Automovil automovil) throws SQLException;
        public void delete(Automovil automovil) throws SQLException;
        public Automovil getQuery(Integer id) throws SQLException;
        public List<Automovil> listar() throws SQLException;


}

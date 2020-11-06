package FabricaAutomoviles.Exception;

import FabricaAutomoviles.Model.Automovil;
import java.util.List;

public interface AutomovilDAO  {

        public Automovil insert(Automovil automovil)  throws DAOException;;
        public void update(Automovil automovil) throws DAOException;
        public void delete(Integer id) throws DAOException;
        public Automovil getQuery(Integer id) throws DAOException;
        public List<Automovil> listar() throws DAOException;


}

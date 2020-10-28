package FabricaAutomoviles.DAO;

import FabricaAutomoviles.Model.Modelo;

public interface ModeloDAO {

        public void insert(Modelo modelo) throws Exception;
        public void update(Modelo modelo) throws Exception;
        public void delete(Modelo modelo) throws Exception;
        public Modelo getQuery(Integer id) throws Exception;

}

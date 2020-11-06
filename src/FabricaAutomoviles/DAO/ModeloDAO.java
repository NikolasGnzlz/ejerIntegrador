package FabricaAutomoviles.DAO;

import FabricaAutomoviles.Model.Modelo;

public interface ModeloDAO {

        public void insert(Modelo modelo) ;
        public void update(Modelo modelo) ;
        public void delete(Modelo modelo) ;
        public Modelo getQuery(Integer id) ;

}

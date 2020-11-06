package FabricaAutomoviles.DAO;

import FabricaAutomoviles.Exception.DAOException;
import FabricaAutomoviles.Model.Cliente;


public interface ClienteDAO {

    public void insert(Cliente cliente) throws DAOException;
    public void update(Cliente cliente) throws Exception;
    public void delete(Cliente cliente) throws Exception;
    public Cliente getQuery(Integer id) throws Exception;
}

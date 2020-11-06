package FabricaAutomoviles.Service.Impl;

import FabricaAutomoviles.DAO.ClienteDAO;
import FabricaAutomoviles.DAO.Implementaciones.ClienteDAOImpl;
import FabricaAutomoviles.DTOS.ClienteDTO;
import FabricaAutomoviles.Exception.DAOException;
import FabricaAutomoviles.Exception.ServiceException;
import FabricaAutomoviles.Model.Cliente;
import FabricaAutomoviles.Service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

    private ClienteDAO clienteDAO ;

    public ClienteServiceImpl() {clienteDAO = new ClienteDAOImpl();    }



    public void ingresarCliente(ClienteDTO cli) throws ServiceException {

        Cliente cliente = converter(cli);

        try {
        clienteDAO.insert(cliente);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("Error al ingresar Cliente " + e.getStackTrace());
        }
    }

    @Override
    public void consultarCliente(int idCliente) throws ServiceException {

        try {
            clienteDAO.getQuery(idCliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("Error al ing Cliente " + e.getStackTrace());
        }


    }

    private Cliente converter(ClienteDTO clienteDTO){

        Cliente cliente = new Cliente();

        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setCuit(clienteDTO.getCuit());

        return  cliente;
    }


}//cierre ClienteServiceImpl


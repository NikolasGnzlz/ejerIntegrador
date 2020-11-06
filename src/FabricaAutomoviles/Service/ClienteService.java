package FabricaAutomoviles.Service;

import FabricaAutomoviles.DTOS.ClienteDTO;
import FabricaAutomoviles.Exception.ServiceException;

public interface ClienteService {

    public void ingresarCliente(ClienteDTO clienteDTO) throws ServiceException;

    public void consultarCliente(int idCliente) throws ServiceException;



}

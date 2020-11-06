package FabricaAutomoviles.Service;

import FabricaAutomoviles.DTOS.AutomovilDTO;
import FabricaAutomoviles.Exception.DAOException;

import java.util.List;


public interface AutomovilService {


        public void ingresarAutomovil(AutomovilDTO automovilDTO)  throws DAOException;//Funcionando

        public AutomovilDTO consultarId(Integer id) throws DAOException;

        public Integer mostrarPrecioAutos(Integer id) throws DAOException;

        public String mostrarNombreAutos(Integer id) throws DAOException;

        public List<AutomovilDTO> consultarAutos() throws DAOException;

        public void deleteAutomovil(Integer id) throws DAOException; //Funcionando


}

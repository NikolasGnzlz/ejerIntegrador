package FabricaAutomoviles.Service;


import FabricaAutomoviles.DTOS.OpcionesDTO;
import FabricaAutomoviles.Model.Opciones;

public interface OpcionesService {

    public void ingresarOpciones(OpcionesDTO opcionesDTO) ;

    public Opciones consultarOpciones(Integer id);


}

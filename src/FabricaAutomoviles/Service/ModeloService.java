package FabricaAutomoviles.Service;

import FabricaAutomoviles.DTOS.ModeloDTO;
import FabricaAutomoviles.Model.Modelo;

public interface ModeloService {

        public void ingresarModelo(ModeloDTO modeloDTO);

        public Modelo consultarModelo(Integer id);

}


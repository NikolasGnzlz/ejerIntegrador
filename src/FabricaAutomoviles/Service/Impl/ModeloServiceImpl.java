package FabricaAutomoviles.Service.Impl;

import FabricaAutomoviles.DTOS.ModeloDTO;
import FabricaAutomoviles.DAO.Implementaciones.ModeloDAOImpl;
import FabricaAutomoviles.Model.Modelo;
import FabricaAutomoviles.Service.ModeloService;

public class ModeloServiceImpl implements ModeloService {

   private ModeloDAOImpl modeloDAO;

   private ModeloDTO modeloDTO;

    public ModeloServiceImpl() {
        this.setModeloDAO(new ModeloDAOImpl());
    }


    public void ingresarModelo(ModeloDTO modeloDTO)  {

        Modelo modelo = converter(modeloDTO);

        this.getModeloDAO().insert(modelo);

    }


    public Modelo consultarModelo(Integer id) {

        Modelo modelo = this.getModeloDAO().getQuery(id);
        return modelo;

    }

    private Modelo converter(ModeloDTO modeloDTO){

        Modelo modelo = new Modelo();
        modelo.setId(modeloDTO.getId());
        modelo.setNombre(modeloDTO.getNombre());
        modelo.setPrecio(modeloDTO.getPrecio());
        return modelo;
    }


    public ModeloDAOImpl getModeloDAO() {
        return modeloDAO;
    }

    public void setModeloDAO(ModeloDAOImpl modeloDAO) {
        this.modeloDAO = modeloDAO;
    }

    public ModeloDTO getModeloDTO() {
        return modeloDTO;
    }

    public void setModeloDTO(ModeloDTO modeloDTO) {
        this.modeloDTO = modeloDTO;
    }
}

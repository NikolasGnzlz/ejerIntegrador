package FabricaAutomoviles.Service.Impl;

import FabricaAutomoviles.DAO.Implementaciones.OpcionesDAOImpl;
import FabricaAutomoviles.DTOS.OpcionesDTO;
import FabricaAutomoviles.Model.Opciones;
import FabricaAutomoviles.Service.OpcionesService;

public class OpcionesServiceImpl implements OpcionesService {

    private OpcionesDAOImpl opcionesDAO;

    private OpcionesDTO opcionesDTO;

    public OpcionesServiceImpl() {
        this.setOpcionesDAO(new  OpcionesDAOImpl());
    }

    @Override
    public void ingresarOpciones(OpcionesDTO opcionesDTO)  {

        Opciones opciones = converter(opcionesDTO);

        this.getOpcionesDAO().insert(opciones);

    }

    public Opciones consultarOpciones(Integer id) {
        Opciones opciones = this.getOpcionesDAO().getQuery(id);
        return opciones;
    }

    private Opciones converter(OpcionesDTO opcionesDTO){

        Opciones opciones = new Opciones();
        opciones.setIdOpcion(opcionesDTO.getIdOpcion());
        opciones.setDescripcion(opcionesDTO.getDescripcion());
        opciones.setPrecio(opcionesDTO.getPrecio());
        return opciones;
    }


    public OpcionesDTO getOpcionesDTO() {
        return opcionesDTO;
    }

    public void setOpcionesDTO(OpcionesDTO opcionesDTO) {
        this.opcionesDTO = opcionesDTO;
    }

    public OpcionesDAOImpl getOpcionesDAO() {
        return opcionesDAO;
    }

    public void setOpcionesDAO(OpcionesDAOImpl opcionesDAO) {
        this.opcionesDAO = opcionesDAO;
    }
}

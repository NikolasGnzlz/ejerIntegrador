package FabricaAutomoviles.Service.Impl;

import FabricaAutomoviles.DTOS.AutomovilDTO;
import FabricaAutomoviles.DTOS.OpcionesDTO;
import FabricaAutomoviles.DAO.Implementaciones.AutomovilDAOImpl;
import FabricaAutomoviles.Model.Automovil;
import FabricaAutomoviles.Model.Opciones;
import FabricaAutomoviles.Service.AutomovilService;
import FabricaAutomoviles.Exception.DAOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AutomovilServiceImpl implements AutomovilService {

    private AutomovilDAOImpl automovilDAO;

    private AutomovilDTO automovilDTO;

    public AutomovilDAOImpl getAutomovilDAO() {
        return automovilDAO;
    }

    public void setAutomovilDAO(AutomovilDAOImpl automovilDAO) {
        this.automovilDAO = automovilDAO;
    }

    public AutomovilDTO getAutomovilDTO() {
        return automovilDTO;
    }

    public void setAutomovilDTO(AutomovilDTO automovilDTO) {
        this.automovilDTO = automovilDTO;
    }


    public AutomovilServiceImpl() { this.automovilDAO =  new AutomovilDAOImpl();  }


    public void ingresarAutomovil(AutomovilDTO automovilDTO) throws DAOException {//funcionando

        Automovil automovil = converter(automovilDTO);

        this.automovilDAO.insert(automovil);

    }


    public AutomovilDTO consultarId(Integer id) throws DAOException {

        Automovil automovil = this.automovilDAO.getQuery(id);
        AutomovilDTO automovilDTO = convert(automovil);

        return automovilDTO;
    }


    public Integer mostrarPrecioAutos(Integer id) throws DAOException {
        Automovil automovil = this.automovilDAO.getQuery(id);
        Integer precioAuto = automovil.getPrecioTotal();
        return precioAuto;
    }

    @Override
    public String mostrarNombreAutos(Integer id) throws DAOException {
        return null;
    }

    /*public String mostrarNombreAutos(Integer id) throws DAOException {
        Automovil automovil = this.automovilDAO.getQuery(id);
          String nombreAutomovil = automovil.getModelo().getNombre();
          return nombreAutomovil;
    }*/


    public List<AutomovilDTO> consultarAutos() throws DAOException {

        List<AutomovilDTO> automovilDTOS = new ArrayList<>();
        List<Automovil> automoviles = this.automovilDAO.listar();
        System.out.println(automoviles.size());
        for (int i = 0; i < automoviles.size() ; i++) {
            automovilDTOS.add(convert(automoviles.get(i)));
        }
        return automovilDTOS;
    }

    //@Override
    public void deleteAutomovil(Integer id) throws DAOException {//funcionando

        this.automovilDAO.delete(id);
    }

    private Opciones converter(OpcionesDTO opcionesDTO){

        Opciones opciones = new Opciones();
        opciones.setIdOpcion(opcionesDTO.getIdOpcion());
        opciones.setDescripcion(opcionesDTO.getDescripcion());
        opciones.setPrecio(opcionesDTO.getPrecio());
        return opciones;
    }

    private Automovil converter(AutomovilDTO automovilDTO){

        Automovil automovil = new Automovil();

        automovil.setId(automovilDTO.getId());
        automovil.setModelo(automovilDTO.getModelo());
        automovil.setModelos(automovilDTO.getModelos());
        automovil.setOpciones(automovilDTO.getOpcionesSet());
        automovil.setOpciones2(automovilDTO.getOpcionesSet().size());
        automovil.setPrecioTotal(automovilDTO.getPrecioTotal());

        return  automovil;
    }
    private AutomovilDTO convert(Automovil automovil){

        AutomovilDTO automovilDTO = new AutomovilDTO();
        automovilDTO.setId(automovil.getId());
        automovilDTO.setModelo(automovil.getModelo());
        automovilDTO.setModelos(automovil.getModelos());
        automovilDTO.setOpcionesSet(automovil.getOpciones());
        automovilDTO.setOpciones2(automovil.getOpciones().size());
        automovilDTO.setPrecioTotal(automovil.precioTotal());
        return automovilDTO;
    }
 //traer metodo  todos los metodos
 /*private int precioAuto(){
     Iterator<Automovil> it = this.automovilDTO.getAutomovil().iterator();
     int precioAuto=0;
     while (it.hasNext()){
         Automovil at = it.next();

         precioAuto += at.getModelo().getPrecio();

         System.out.println("\n Modelo  : "+at.getModelo().getNombre()  +
                 "\n Precio Unidad " + at.getModelo().getPrecio() );
     }
     return precioAuto;
 }//Cierra precioAuto*/

    private int calcularOpciones(){
        Iterator<Opciones> it = this.automovilDTO.getOpcionesSet().iterator();
        int sumaOp =0;
        while (it.hasNext()){
            Opciones auto = it.next();
            sumaOp = sumaOp + auto.getPrecio();

            System.out.println( "Opciones agregadas al auto :"
                    +auto.getDescripcion()+" "+ auto.getPrecio()  );
        }
        System.out.println("Suma Total de opciones :" + sumaOp  );
        return sumaOp;
    }//Cierra calcularOpciones



    public void precioTotal(){
        int sumaOp = calcularOpciones();
        int precioAuto = this.automovilDTO.getModelo().getPrecio();

         this.automovilDTO.setPrecioTotal(sumaOp + precioAuto);

        System.out.println("\n Precio Modelo del auto : "+ precioAuto+ "\n Total Opciones agregadas al auto : "+ sumaOp+
                "\n Total precio del Auto :"+this.automovilDTO.getPrecioTotal()+"\n"+"************************************************");

    }//Cierra PrecioTotal


}//Cierra AutomovilServiceImpl

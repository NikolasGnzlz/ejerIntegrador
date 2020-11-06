package FabricaAutomoviles;

import FabricaAutomoviles.DAO.Implementaciones.AutomovilDAOImpl;
import FabricaAutomoviles.DAO.Implementaciones.ClienteDAOImpl;
import FabricaAutomoviles.DAO.Implementaciones.ModeloDAOImpl;
import FabricaAutomoviles.DAO.Implementaciones.OpcionesDAOImpl;
import FabricaAutomoviles.Exception.AutomovilDAO;
import FabricaAutomoviles.DAO.ClienteDAO;
import FabricaAutomoviles.DAO.ModeloDAO;
import FabricaAutomoviles.DAO.OpcionesDAO;
import FabricaAutomoviles.DTOS.AutomovilDTO;
import FabricaAutomoviles.Model.Automovil;
import FabricaAutomoviles.Model.Cliente;
import FabricaAutomoviles.Model.Modelo;
import FabricaAutomoviles.Model.Opciones;
import FabricaAutomoviles.Service.Impl.AutomovilServiceImpl;
import FabricaAutomoviles.Service.Impl.ModeloServiceImpl;
import FabricaAutomoviles.Service.Impl.OpcionesServiceImpl;

import java.util.List;

public class Main {
           public static void main(String[] args) throws Exception {


            /*           Clientes          */
            Cliente cli1 = new Cliente();
            cli1.setIdCliente(1);
            cli1.setNombre("Nikolas");
            cli1.setApellido("Gonzalez");
            cli1.setCuit("20-95405278-9");

            Cliente cli2 = new Cliente();
            cli2.setIdCliente(2);
            cli2.setNombre("Ricardo");
            cli2.setApellido("Romero");
            cli2.setCuit("20-95654248-0");

            Cliente cli3 = new Cliente();
            cli3.setIdCliente(4);
            cli3.setNombre("Javier");
            cli3.setApellido("Cardenas");
            cli3.setCuit("21-96024729-3");

            ///////////////////////////////////////////////////////////////////////////////////
            /*        MODELOS DE AUTO       */

            Modelo mod1 = new Modelo();
            mod1.setId(1);
            mod1.setNombre("Sedan");
            mod1.setPrecio(230000);

            Modelo mod2 = new Modelo();
            mod2.setId(2);
            mod2.setNombre("Familiar");
            mod2.setPrecio(245000);

            Modelo mod3 = new Modelo();
            mod3.setId(3);
            mod3.setNombre("Coupe");
            mod3.setPrecio(270000);

            ////////////////////////////////////////////////////////////////////////////////////
            /* OPCIONES DE AUTO */

            Opciones TC = new Opciones();
            TC.setIdOpcion(1);
            TC.setDescripcion("Techo Corredizo");
            TC.setPrecio(12000);

            Opciones AA = new Opciones();
            AA.setIdOpcion(2);
            AA.setDescripcion("Aire acondicionado");
            AA.setPrecio(20000);

            Opciones ABs = new Opciones();
            ABs.setIdOpcion(3);
            ABs.setDescripcion("Sistemas de frenos ABS");
            ABs.setPrecio(14000);

            Opciones AB = new Opciones();
            AB.setIdOpcion(4);
            AB.setDescripcion("Airbag");
            AB.setPrecio(7000);

            Opciones LL = new Opciones();
            LL.setIdOpcion(5);
            LL.setDescripcion("Llantas de aleación");
            LL.setPrecio(12000);


            ///////////////////////////////////////////////////////////////////////////////////

            Automovil aut1 = new Automovil();
            aut1.addCliente(cli1);
            aut1.setId(1);
            aut1.setModelo(mod1);
            aut1.addModelo(aut1);
            aut1.addOpcion(AB);
            aut1.addOpcion(TC);
            aut1.precioTotal();

            Automovil aut2 = new Automovil();
            aut2.addCliente(cli2);
            aut1.setId(2);
            aut2.setModelo(mod2);
            aut2.addModelo(aut2);
            aut2.precioTotal();

            Automovil aut3 = new Automovil();
            aut3.addCliente(cli3);
            aut1.setId(3);
            aut3.setModelo(mod3);
            aut3.addModelo(aut3);
            aut3.addOpcion(TC);
            aut3.addOpcion(AB);
            //aut3.addOpcion(ABs);
            aut3.addOpcion(AA);
            aut3.addOpcion(LL);
            aut3.precioTotal();

            Automovil aut4 = new Automovil();
            aut4.setModelo(mod2);
            aut4.addModelo(aut4);
            aut4.precioTotal();


            //////////////////////////////////////////////////////////////////////////////////////////////////

            //para conectar con la Base de Datos--> SET GLOBAL time_zone = '+3:00';

            ///////// Funcionando

            ClienteDAO clidao = new ClienteDAOImpl();
            clidao.update(cli3);

            Cliente tes = clidao.getQuery(2);

            System.out.println("Id :"+tes.getIdCliente()+" "+"Nombre Cliente: "+tes.getNombre()+" "+"Cuit :"+tes.getCuit());

            ///////// Funcionando

            ModeloDAO dao = new ModeloDAOImpl();
            Modelo prueba1 = dao.getQuery(4);

            System.out.println("Id :"+prueba1.getId()+" "+"Nombre Modelo: "+prueba1.getNombre()+" "+"Precio :"+prueba1.getPrecio());



            ///////// Funcionando

            OpcionesDAO opdao = new OpcionesDAOImpl();
            Opciones test = opdao.getQuery(5);
            System.out.println("\n Id :"+test.getIdOpcion()+" "+"Descripcion Opcion: "+test.getDescripcion()+" "+"Precio :"+test.getPrecio());

            ///////// Funcionando

            AutomovilDAO Audao = new AutomovilDAOImpl();

            Automovil test2 = Audao.getQuery(3);
            System.out.println("\n Id :"+test2.getId()+" "+"Nombre Modelo: "+test2.getNombre()+" "+"Precio Total :"+test2.getPrecioTotal());



            /* Funcion para listar los Automoviles - segun id, Nombre de modelo, Precio Total del auto  */

            for (Automovil A: Audao.listar() ) {
                System.out.println("\n Id:"+A.getId()+" "+"Modelo:"+A.getNombre()+" "+"Precio Total:"+A.getPrecioTotal()+"\n" +
                        "*******Temina las prubas de la entrega °3 ******");
            }

            AutomovilServiceImpl automovilService = new AutomovilServiceImpl();


            //lista de autos
            List<AutomovilDTO> au = null;
             au = automovilService.consultarAutos();//.consultarId(4);
            for (AutomovilDTO aut: au ) {
                System.out.println("consultar autos :"+au);//.getId()+ " modelo "+ aut.getAutomovil() + " precio "+ aut.getPrecioTotal());
            }

            //consultar id
            AutomovilDTO auto = automovilService.consultarId(4);
            System.out.println(" DTO consultar id :"+ auto.getId()+" "+auto.getAutomovil());


            AutomovilServiceImpl autoSer = new AutomovilServiceImpl();
            ModeloServiceImpl modeloService = new ModeloServiceImpl();
            OpcionesServiceImpl opcionesService = new OpcionesServiceImpl();
            AutomovilDTO auto32 = new AutomovilDTO();


            autoSer.setAutomovilDTO(auto32);

            auto32.setId(7);
            auto32.setModelo(modeloService.consultarModelo(1));
            //auto32.addModelo(modeloService.consultarModelo(2));//tratar de meter un id de un automovile de la bd
            auto32.addOpcion(opcionesService.consultarOpciones(2));
            auto32.addOpcion(opcionesService.consultarOpciones(4));
            autoSer.precioTotal();

            //automovilService.ingresarAutomovil(auto32); Funcionando

            // automovilService.deleteAutomovil(10); //Funcionando

           // String pr = autoSer.mostrarNombreAutos(4);
            Integer in = autoSer.mostrarPrecioAutos(4);
            System.out.println(" precio "+ in );
            System.out.println("mostrar precio de auto segun id :"+autoSer.getAutomovilDTO().getId() + autoSer.getAutomovilDTO().getPrecioTotal());

            /*
             * DTO solo atributos del paquete model
             * Service solo metodos del paquete model
             * en el Serviceimple siempre vamos a tner un atributo de (DAO solo memoria del DAO) y DTO
             * Paquete controler siempre tener un atributo Services con memoria ( new )
             * */







        }//Cierra metodo main





    }//Cierra class FabricaAutomoviles.Main.Main


/*Tomando como referencia los ejercicios Integradores 2 y 3 y
lo visto en clase, exponer los  siguientes recursos y operaciones con sus respectivos manejos de excepciones

Automóvil:

Alta
Baja
Modificación
Consulta de Automóviles ( listado ) *
Consulta de Precio por automóvil *
Adicionales:

Alta
Baja
Modificación
Consulta.

* */

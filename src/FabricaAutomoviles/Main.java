package FabricaAutomoviles;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
                            /*          Clientes            */
        Cliente cli1 = new Cliente("Nikolas","Gonzalez","20-95405278-9" );
        Cliente cli2 = new Cliente("Ricardo", "Romero","20-95654248-0");
        Cliente cli3 = new Cliente("Javier","Javidich","20-96024729-3");

        ///////////////////////////////////////////////////////////////////////////////////
                            /*        MODELOS DE AUTO          */

        Modelo mod1 = new Modelo("Sedan",230000);
        Modelo mod2 = new Modelo("Familiar",245000);
        Modelo mod3 = new Modelo("Coupe",270000);

        ////////////////////////////////////////////////////////////////////////////////////
                              /*        OPCIONES DE AUTO          */

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
            aut1.setModelo(mod1);
            aut1.addModelo(aut1);
            aut1.addOpcion(AB);
            aut1.addOpcion(TC);
            aut1.precioTotal();

        Automovil aut2 = new Automovil();
            aut2.addCliente(cli2);
            aut2.setModelo(mod2);
            aut2.addModelo(aut2);
            aut2.precioTotal();

        Automovil aut3 = new Automovil();
            aut3.addCliente(cli3);
            aut3.setModelo(mod3);
            aut3.addModelo(aut3);
            aut3.addOpcion(TC);
            aut3.addOpcion(AB);
            aut3.addOpcion(ABs);
            aut3.addOpcion(AA);
            aut3.addOpcion(LL);
            aut3.precioTotal();


 //////////////////////////////////////////////////////////////////////////////////////////////////








    }//Cierra metodo main





}//Cierra class Main

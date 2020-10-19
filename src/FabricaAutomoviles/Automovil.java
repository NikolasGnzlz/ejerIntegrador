package FabricaAutomoviles;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Automovil {
    private Modelo modelo;
    private Set<Cliente> cliente;
    private Set<Automovil> automovil;
    private Set<Opciones> opciones;
    private int precioTotal = 0;

    public Automovil() {

        this.cliente = new HashSet<Cliente>();
        this.automovil = new HashSet<Automovil>();
        this.opciones = new HashSet<Opciones>();

    }

    public int getPrecioTotal() { return precioTotal; }

    public void setPrecioTotal(int precioTotal) { this.precioTotal = precioTotal; }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Set<Opciones> getOpciones() {
        return opciones;
    }

    public void setOpciones(Set<Opciones> opciones) {
        this.opciones = opciones;
    }

    public void addOpcion(Opciones opciones){
        this.opciones.add(opciones);
    }

    public Set<Automovil> getAutomovil(){ return automovil; }

    public void setAutomovil(Set<Automovil> automovil){ this.automovil = automovil; }

    public void addModelo(Automovil automovil){
        this.automovil.add(automovil);
    }

    public Set<Cliente> getCliente(){ return cliente; }

    public void setCliente(Set<Cliente> cliente){ this.cliente = cliente; }

    public void addCliente(Cliente cliente){ this.cliente.add(cliente); }


    private int precioAuto(){
        Iterator<Automovil> it = getAutomovil().iterator();//this.automovil.iterator();
        int precioAuto=0;
        while (it.hasNext()){
            Automovil at = it.next();
            //int preciobasicoAuto = precioBasico(at);
            precioAuto += at.getModelo().getPrecio();

            System.out.println("\n Modelo  : "+at.getModelo().getNombre()  +//at.getModelo().getNombre()  +
                    "\n Precio Unidad " + at.getModelo().getPrecio() );
        }
        return precioAuto;
    }//Cierra precioAuto

    private int calcularOpciones(){
        Iterator<Opciones> it = getOpciones().iterator();   //aut1.getOpciones().iterator();
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

    private String comprador(){
        Iterator<Cliente> it = getCliente().iterator();//this.automovil.iterator();
        String compradorAuto="";
        while (it.hasNext()){
            Cliente cl = it.next();
            //int preciobasicoAuto = precioBasico(at);
            compradorAuto += cl.getNombre()+" "+ cl.getApellido();

            System.out.println("\n Datos del Comprador  : "+cl.getNombre()+" "+ cl.getApellido()+" "+cl.getCuit());
        }
        return compradorAuto;
    }//Cierra comprador


    public void precioTotal(){
       int sumaOp = calcularOpciones();
       int precioAuto = precioAuto();
       String compradorAuto = comprador();
        this.precioTotal =sumaOp + precioAuto;

        System.out.println("\n Nombre completo del comprador :"+compradorAuto+"\n Precio Modelo del auto : "+ precioAuto+ "\n Total Opciones agregadas al auto : "+ sumaOp+
                "\n Total precio del Auto :"+this.precioTotal+"\n"+"************************************************");
    }//Cierra PrecioTotal




}//Cierra Automovil

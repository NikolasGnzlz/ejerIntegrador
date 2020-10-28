package FabricaAutomoviles.Model;
/*
* Una fábrica de automóviles produce uno de sus modelos en tres variantes, llamadas sedán, coupé y familiar.
* Cada una tiene un precio de venta básico sin opcionales. A su vez, a cada variante se le pueden agregar opciones
* como techo corredizo, aire acondicionado, sistema de frenos AB, airbag y llantas de aleación. Cada uno de estos
* opcionales tiene un precio que suma al básico. En este caso, cada auto vendrá caracterizado por su variante y
* podrá tener ninguno, uno o más opcionales.

Asumiendo los siguientes costos:

•          Básico sedán          230.000

•          Básico familiar        245.000

•          Básico coupé          270.000

•          Techo corredizo (TC)        12.000

•          Aire acondicionado (AA)  20.000

•          Sistemas de frenos ABs (ABS)    14.000

•          Airbag (AB)   7.000

•          Llantas de aleación (LL)   12.000

1)Diseñar una solución que permita calcular el costo final de un automóvil.

2) Realizar un diseño de base de datos en MySql para almacenar los datos de la solución
* */



public class Cliente {
    private  int idCliente;
    private String nombre;
    private String apellido;
    private String cuit;

    public Cliente(int idCliente,String nombre, String apellido,String cuit ){
        this.setIdCliente(idCliente);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCuit(cuit);

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}

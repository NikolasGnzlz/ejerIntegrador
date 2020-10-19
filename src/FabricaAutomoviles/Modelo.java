package FabricaAutomoviles;

public class Modelo {
    private String nombre;
    private int precio;

    public Modelo(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }




}//Cierra Modelo





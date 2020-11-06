package FabricaAutomoviles.DTOS;
import FabricaAutomoviles.Model.Automovil;
import FabricaAutomoviles.Model.Modelo;
import FabricaAutomoviles.Model.Opciones;

import java.util.HashSet;
import java.util.Set;

public class AutomovilDTO {

    private Integer id;
    private String nombre;
    private Modelo modelo;
    private Set<Modelo> modelos;

    private Set<Automovil> automovil;
    private Set<Opciones> opcionesSet;
    private Integer opciones;
    private Integer precioTotal ;

    public AutomovilDTO() {

        this.setAutomovil(new HashSet<Automovil>());
        this.setOpcionesSet(new HashSet<Opciones>());

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setOpciones2(Integer opciones) {
        this.opciones = opciones;
    }

    public Set<Automovil> getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Set<Automovil> automovil) {
        this.automovil = automovil;
    }

    public Set<Opciones> getOpcionesSet() {
        return opcionesSet;
    }

    public void setOpcionesSet(Set<Opciones> opcionesSet) {
        this.opcionesSet = opcionesSet;
    }

    public Set<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(Set<Modelo> modelos) {
        this.modelos = modelos;
    }

    public void addOpcion(Opciones opcionesSet){
        this.opcionesSet.add(opcionesSet);
    }



}//Cierra AutomovilDTO

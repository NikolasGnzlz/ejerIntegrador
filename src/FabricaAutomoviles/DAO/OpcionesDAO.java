package FabricaAutomoviles.DAO;


import FabricaAutomoviles.Model.Opciones;

public interface OpcionesDAO {

    public void insert(Opciones opciones) ;
    public void update(Opciones opciones) ;
    public void delete(Opciones opciones) ;
    public Opciones getQuery(Integer id) ;

}

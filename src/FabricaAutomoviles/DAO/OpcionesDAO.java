package FabricaAutomoviles.DAO;


import FabricaAutomoviles.Model.Opciones;

public interface OpcionesDAO {

    public void insert(Opciones opciones) throws Exception;
    public void update(Opciones opciones) throws Exception;
    public void delete(Opciones opciones) throws Exception;
    public Opciones getQuery(Integer id) throws Exception;

}

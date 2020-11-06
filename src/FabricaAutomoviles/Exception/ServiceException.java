package FabricaAutomoviles.Exception;

public class ServiceException extends DAOException {

    public ServiceException(){
        super();
    }

    public ServiceException(String mesagge){
        super(mesagge);
    }

    public ServiceException(Throwable cause){
        super(cause);
    }

    public ServiceException(String message, Throwable couse) {
        super(message, couse);
    }

}

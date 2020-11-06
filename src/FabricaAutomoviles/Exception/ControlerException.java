package FabricaAutomoviles.Exception;

public class ControlerException extends ServiceException {

    public ControlerException(){
        super();
    }

    public ControlerException(String mesagge){
        super(mesagge);
    }

    public ControlerException(Throwable cause){
        super(cause);
    }

    public ControlerException(String message, Throwable couse) {
        super(message, couse);
    }

}

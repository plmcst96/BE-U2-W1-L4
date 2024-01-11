package exception;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(long id) {
        super("La pizza con id " + id + " non è stata trovata!");
    }
}

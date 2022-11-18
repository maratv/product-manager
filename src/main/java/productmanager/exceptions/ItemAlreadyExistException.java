package productmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ItemAlreadyExistException extends RuntimeException{

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public ItemAlreadyExistException(String message) {
        super("Item with name: '" + message + "' already exist");
    }
}


package by.prus.forfesco.myexception;

import java.util.Date;

public class EntityException extends RuntimeException {

    private static final long serialVersionUID = 1348771109171435607L;

    public EntityException(String message) {
        super(message);
    }
}

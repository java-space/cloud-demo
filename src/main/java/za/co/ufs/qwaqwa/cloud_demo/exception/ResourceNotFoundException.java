package za.co.ufs.qwaqwa.cloud_demo.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final String errorMessage;

    public ResourceNotFoundException(String message) {
        super(message);
        this.errorMessage = message;
    }
}

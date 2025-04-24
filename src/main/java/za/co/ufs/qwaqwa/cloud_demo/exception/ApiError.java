package za.co.ufs.qwaqwa.cloud_demo.exception;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;

@Data
@Builder
@Accessors(chain = true)
public class ApiError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}

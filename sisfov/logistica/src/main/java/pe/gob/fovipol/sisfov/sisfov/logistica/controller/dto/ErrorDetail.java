package pe.gob.fovipol.sisfov.sisfov.logistica.controller.dto;

import lombok.Data;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ErrorDetail {
    private String title;
    private int status;
    private String detail;
    private long timeStamp;


    private Map<String, List<ValidationError>> errors = new HashMap<>();
}

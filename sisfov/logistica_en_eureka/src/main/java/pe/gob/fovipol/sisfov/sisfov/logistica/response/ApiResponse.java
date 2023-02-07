package pe.gob.fovipol.sisfov.sisfov.logistica.response;

import org.keycloak.authorization.client.util.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public interface ApiResponse {

    public ResponseEntity<?> successResponse(Object o, HttpStatus code);
    public ResponseEntity<?> successResponseStatus(String message, HttpStatus code, boolean error);
    public ResponseEntity<?> successResponseStatus(String message, HttpStatus code);
    public ResponseEntity<?> successResponseStatus(String message);
    public ResponseEntity<?> errorResponse(String message, HttpStatus code, boolean error);
    public ResponseEntity<?> errorResponse(String message, HttpStatus code);
    public ResponseEntity<?> errorResponse(String message);

    public ResponseEntity<?> validar(BindingResult result);

}

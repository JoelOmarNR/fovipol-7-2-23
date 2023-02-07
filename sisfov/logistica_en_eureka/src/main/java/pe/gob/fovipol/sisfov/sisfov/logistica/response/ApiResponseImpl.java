package pe.gob.fovipol.sisfov.sisfov.logistica.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class ApiResponseImpl implements ApiResponse{
    @Override
    public ResponseEntity<?> successResponse(Object o, HttpStatus code) {
        Map<String, Object> rp = new HashMap<String, Object>();
        rp.put("error", false);
        rp.put("data", o);
        return new ResponseEntity<Map<String, Object>>(rp,code);
    }

    @Override
    public ResponseEntity<?> successResponseStatus(String message, HttpStatus code, boolean error) {
        Map<String, Object> rp = new HashMap<String, Object>();
        rp.put("error", error);
        rp.put("message", message);
        return new ResponseEntity<Map<String, Object>>(rp,code);
    }

    @Override
    public ResponseEntity<?> successResponseStatus(String message, HttpStatus code) {
        Map<String, Object> rp = new HashMap<String, Object>();
        rp.put("error", false);
        rp.put("message", message);
        return new ResponseEntity<Map<String, Object>>(rp,code);
    }

    @Override
    public ResponseEntity<?> successResponseStatus(String message) {
        Map<String, Object> rp = new HashMap<String, Object>();
        rp.put("error", false);
        rp.put("message", message);
        return new ResponseEntity<Map<String, Object>>(rp,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> errorResponse(String message, HttpStatus code, boolean error) {
        Map<String, Object> rp = new HashMap<String, Object>();
        rp.put("error", error);
        rp.put("message", message);
        return new ResponseEntity<Map<String, Object>>(rp,code);
    }

    @Override
    public ResponseEntity<?> errorResponse(String message, HttpStatus code) {
        Map<String, Object> rp = new HashMap<String, Object>();
        rp.put("error", true);
        rp.put("message", message);
        return new ResponseEntity<Map<String, Object>>(rp,code);
    }

    @Override
    public ResponseEntity<?> errorResponse(String message) {
        Map<String, Object> rp = new HashMap<String, Object>();
        rp.put("error", true);
        rp.put("message", message);
        return new ResponseEntity<Map<String, Object>>(rp,HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}

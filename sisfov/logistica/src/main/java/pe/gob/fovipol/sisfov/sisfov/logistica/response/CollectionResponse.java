package pe.gob.fovipol.sisfov.sisfov.logistica.response;

import java.util.List;

public class CollectionResponse {

    private long code;
    private String message;

    private boolean error;

    private List<Object> lista;

    public CollectionResponse() {

    }

    public CollectionResponse(long code, String message, boolean error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean status) {
        this.error = error;
    }

    public List<Object> getLista() {
        return lista;
    }

    public void setLista(List<Object> lista) {
        this.lista = lista;
    }
}

package pe.gob.fovipol.sisfov.sisfov.logistica.response;

public class OneReponse {

    private long code;
    private String message;

    private boolean error;

    private Object object;

    public OneReponse(long code, String message, boolean error) {
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

    public void setError(boolean error) {
        this.error = error;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

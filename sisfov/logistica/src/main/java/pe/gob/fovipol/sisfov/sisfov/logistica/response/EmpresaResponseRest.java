package pe.gob.fovipol.sisfov.sisfov.logistica.response;

public class EmpresaResponseRest extends ResponseRest{

    private EmpresaResponse empresaResponse = new EmpresaResponse();

    public EmpresaResponse getEmpresaResponse() {
        return empresaResponse;
    }

    public void setEmpresaResponse(EmpresaResponse empresaResponse) {
        this.empresaResponse = empresaResponse;
    }
}

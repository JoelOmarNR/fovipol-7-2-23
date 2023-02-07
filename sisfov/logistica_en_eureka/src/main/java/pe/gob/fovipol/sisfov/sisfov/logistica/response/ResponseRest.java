package pe.gob.fovipol.sisfov.sisfov.logistica.response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {

    private ArrayList<HashMap<String, String>> metadata=new ArrayList<>();
    public ArrayList<HashMap<String, String>>getMetadata(){
        return metadata;
    }

    public void setMetadata(String tipo,String codigo,String message) {
        HashMap<String, String> mapa = new HashMap<String, String>();
        mapa.put("tipo", tipo);
        mapa.put("codigo",codigo);
        mapa.put("message", message);


        metadata.add(mapa);
    }
}

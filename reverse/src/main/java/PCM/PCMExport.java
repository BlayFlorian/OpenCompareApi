package PCM;

import org.json.JSONObject;

public class PCMExport {
    PCM pcm;
    JSONObject json;
    public PCMExport(PCM pcm) {
        this.pcm = pcm;
        JSONObject jsonObject = pcm.metadata.toJson();
        jsonObject = pcm.featureToJson(jsonObject);
        json = pcm.productToJson(jsonObject);
    }

    public JSONObject getJson(){
        return json;
    }

}

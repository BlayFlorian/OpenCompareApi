package PCM;

import org.json.JSONObject;

public class PCMExport {
    PCM pcm;
    String json;
    public PCMExport(PCM pcm) {
        this.pcm = pcm;
        JSONObject jsonObject = pcm.metadata.toJson();
        jsonObject = pcm.featureToJson(jsonObject);
        jsonObject = pcm.productToJson(jsonObject);
        json = jsonObject.toString();
        System.out.println(json);
    }

    public String getJson(){
        return json;
    }

}

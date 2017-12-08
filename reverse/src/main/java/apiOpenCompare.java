import org.json.JSONObject;
import webService.ApiCall;
import PCM.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class apiOpenCompare
{
    public static void main(String[] args) {
        String myURL = "https://opencompare.org/api/59c3d669384f2b07bbda544c";
        ApiCall call = new ApiCall(myURL);
        JSONObject json = call.getJsonObj();
        LinkedHashMap features = new LinkedHashMap<String, Features>();
        LinkedHashMap products = new LinkedHashMap<String,Map>();
        PCM pcm = new PCM(features,products);
        pcm.setJson(json);
        pcm.setMetadata();
        pcm.setFeatures();
        pcm.setProductsCells();
        PCMExport pcmExport = new PCMExport(pcm);
    }
}

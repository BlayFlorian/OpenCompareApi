import org.json.JSONObject;
import webService.ApiCall;
import PCM.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class apiOpenCompare
{
    public static void main(String[] args) {
        String myURL = "https://opencompare.org/api/59c3d669384f2b07bbda544c";
        ApiCall call = new ApiCall(myURL);
        JSONObject json = call.getJsonObj();
        PCM pcm = new PCM(json);
        PCMExport pcmExport = new PCMExport(pcm);
        JSONObject jsonObject2 = pcmExport.getJson();
        PCM pcm2 = new PCM(jsonObject2);
        PCMExport pcmExport1 = new PCMExport(pcm2);
        System.out.println(pcmExport1.getJson().toString());
    }
}

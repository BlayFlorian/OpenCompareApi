import org.json.JSONObject;
import webService.ApiCall;
import PCM.*;

import java.util.HashMap;
import java.util.Map;

public class apiOpenCompare
{
    public static void main(String[] args) {

        String myURL = "https://opencompare.org/api/59c3d669384f2b07bbda544c";
        ApiCall call = new ApiCall(myURL);
        JSONObject json = call.getJsonObj();
        Map features = new HashMap<String, Features>();
        Map products = new HashMap<String,Map>();
        Metadata metadata = new Metadata();
        PCM pcm = pcm = new PCM(metadata,features,products);
        pcm.setJson(json);
        pcm.setMetadata();
        pcm.setFeatures();
        pcm.setProductsCells();

        System.out.println(metadata.toString());


    }
}

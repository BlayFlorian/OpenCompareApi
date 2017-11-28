import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import webService.ApiCall;

public class apiOpenCompare
{
    public static void main(String[] args) {
        String myURL = "https://opencompare.org/api/59b146841ce2640a4802dfac";
        ApiCall call = new ApiCall(myURL);
        JSONObject json = call.getJsonObj();
        PCMCreator pcmCreator = new PCMCreator(json);
    }
}

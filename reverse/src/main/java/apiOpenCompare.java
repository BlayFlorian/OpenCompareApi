import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import webService.ApiCall;
import PCM.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class apiOpenCompare
{
    public static void main(String[] args) throws IOException {
        System.out.println("Entrez un id");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        String myURL = "https://opencompare.org/api/" + id;

        ApiCall call = new ApiCall(myURL);
        JSONObject json = call.getJsonObj();

        PCM pcm = new PCM(json);

        PCMExport pcmExport = new PCMExport(pcm);

        JSONObject json2 = pcmExport.getJson();

        //Comparaison
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree1 = mapper.readTree(json.toString());
        JsonNode tree2 = mapper.readTree(json2.toString());
        System.out.println(tree1.equals(tree2));
        System.out.println(json2.toString());
    }
}

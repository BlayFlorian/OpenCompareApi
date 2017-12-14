package PCM;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;
import webService.ApiCall;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PCMTest {
    @Test
    public void getProducts() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    @Test
    public void tests() throws Exception {
        String myURL = "https://opencompare.org/api/5a17ec1e086cfd088ff72de9";
        ApiCall call = new ApiCall(myURL);
        JSONObject json = call.getJsonObj();

        PCM pcm = new PCM(json);
        PCMExport pcmExport = new PCMExport(pcm);
        JSONObject json2 = pcmExport.getJson();

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode tree = mapper.readTree(json.toString());
            try {
                JsonNode tree2 = mapper.readTree(json2.toString());
                assertTrue(tree.equals(tree2));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        pcm.features.forEach((k,v) -> {
            if(k.equals("F1")){
                pcm.features.get(k).setId("Ceci est un ID");
            }
        });
        Metadata m = pcm.getMetadata();
        m.setAuthor("Auteur");
        m.set_id("id");
        m.setDescription("desc");
        m.setFeatureIdGen("id");
        m.setLicence("licence");
        m.setPrimaryFeatureId("1");
        m.setName("name");
        m.setSource("source");
        m.setProductIdGen("1");
        Map<String, Products> products = pcm.getProducts();
        products.forEach((k,v)-> {products.get(k).getId();});

        PCMExport pcmExport2 = new PCMExport(pcm);
        JSONObject jsonM = pcmExport2.getJson();

        ObjectMapper mapper2 = new ObjectMapper();
        try {
            JsonNode tree = mapper2.readTree(json.toString());
            try {
                JsonNode tree2 = mapper2.readTree(jsonM.toString());
                assertFalse(tree.equals(tree2));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
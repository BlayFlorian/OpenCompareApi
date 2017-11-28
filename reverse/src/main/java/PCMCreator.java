import PCM.PCM;
import com.sun.org.apache.xalan.internal.utils.FeatureManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PCMCreator {

    PCM pcm;
    JSONObject json;

    public PCMCreator (JSONObject json){
        this.json = json;
        setMetadata();
        setFeatures();
        setProductsCells();
    }

    private String notNull(String key) {
        Object obj;
        try {
            obj = json.get(key);
            if(obj ==null || obj.toString().length()==0)
            { return "null"; }
            else { return  obj.toString(); }
        } catch (JSONException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    private void setMetadata() {
        try {
            String author = notNull("author");
            String source = notNull("source");
            String licence = notNull("license");
            String name = notNull("name");
            String description = notNull("description");
            int featureIdGen = json.getInt("featureIdGen");
            String primaryFeatureId = notNull("primaryFeatureId");
            int productIdGen = json.getInt("productIdGen");
            String _id = notNull("_id");

            pcm = new PCM(author,source,description,licence,name,featureIdGen,primaryFeatureId,productIdGen,_id);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setFeatures(){
        try {
            JSONArray features = json.getJSONArray("features");
            for(int i = 0; i < features.length(); i++) {
                String name = features.getJSONObject(i).getString("name");
                String id = features.getJSONObject(i).getString("id");
                String type = features.getJSONObject(i).getString("type");
                pcm.setFeatures(id,name, type);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setProductsCells(){
        try{
            JSONArray products = json.getJSONArray("products");
            for(int i = 0; i< products.length(); i++){
                String id = products.getJSONObject(i).getString("id");
                JSONArray cells = products.getJSONObject(i).getJSONArray("cells");
                pcm.setProduct(id);
                for (int y =0; y < cells.length();y++){
                    JSONObject cell = cells.getJSONObject(y);
                    String value;
                    if(cell.getString("type") == "number") {
                        value =  Integer.toString(cell.getInt("value"));
                    } else {
                        value = cell.getString("value");
                    }
                    pcm.setCells(cell.getString("featureId"),cell.getString("type"),cell.getString("unit"),value, id);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(pcm.getProducts().get("P0").get("F1").toString());
    }


}

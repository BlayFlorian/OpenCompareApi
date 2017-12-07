package PCM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class PCM {

    JSONObject json;
    Metadata metadata;
    Features feature;
    Cells c;
    Map<String, Features> features;
    Map<String,Cells> cell;
    Map<String,Map> products;

    public PCM (Metadata metadata,Map<String, Features> features, Map<String,Map> products){
        this.metadata = metadata;
        this.features = features;
        this.products = products;
      //  features = new HashMap<String, Features>();
      //  products = new HashMap<String,Map>();
        feature = new Features();

    }

    public Map<String, Map> getProducts(){
        return products;
    }

    public void addFeatures(String id, Features feature) {
        features.put(id, feature);
    }

    public void addProduct(String id){
        cell = new HashMap<String, Cells>();
        products.put(id, cell);
    }

    public  void addCells(Cells c, String idProduct){
        products.get(idProduct).put(c.getFeatureId(), c);
    }
    public void setJson(JSONObject json) {
        this.json = json;
    }
    public JSONObject getJson() {
        return json;
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
    public void setMetadata() {
        try {
            metadata.setAuthor(notNull("author"));
            metadata.setSource(notNull("source"));
            metadata.setLicence(notNull("license"));
            metadata.setName(notNull("name"));
            metadata.setDescription(notNull("description"));
            metadata.setFeatureIdGen(json.getInt("featureIdGen"));
            metadata.setPrimaryFeatureId(notNull("primaryFeatureId"));
            metadata.setProductIdGen(json.getInt("productIdGen"));
            metadata.set_id(notNull("_id"));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setFeatures(){
        try {
            JSONArray features = json.getJSONArray("features");
            for(int i = 0; i < features.length(); i++) {
                feature.setName(features.getJSONObject(i).getString("name"));
                feature.setType(features.getJSONObject(i).getString("type"));
                String id = features.getJSONObject(i).getString("id");

                addFeatures(id,feature);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setProductsCells(){
        try{
            JSONArray productsJson = json.getJSONArray("products");
            for(int i = 0; i< productsJson.length(); i++){
                String id = productsJson.getJSONObject(i).getString("id");
                JSONArray cellsJson = productsJson.getJSONObject(i).getJSONArray("cells");
                addProduct(id);
                for (int y =0; y < cellsJson.length();y++){
                    JSONObject cellJson = cellsJson.getJSONObject(y);
                    c = new Cells();
                    if(cellJson.getString("type") == "number") {
                        c.setValue(Integer.toString(cellJson.getInt("value")));
                    } else {
                        c.setValue(cellJson.getString("value"));
                    }
                    c.setType(cellJson.getString("type"));
                    c.setUnit(cellJson.getString("unit"));
                    c.setPartial(cellJson.getBoolean("isPartial"));
                    c.setFeatureId(cellJson.getString("featureId"));
                    addCells(c, id);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(getProducts().get("P0").get("F5").toString());
    }


}

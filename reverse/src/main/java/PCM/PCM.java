package PCM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;

public class PCM  {

    JSONObject json;

    Metadata metadata;
    Cells c;
    LinkedHashMap<String, Features> features;
    LinkedHashMap<String,Cells> cell;
    LinkedHashMap<String,Products> products;

    public PCM (JSONObject json){
        this.features = new LinkedHashMap<String, Features>();
        this.products = new LinkedHashMap<String, Products>();
        this.json = json;
        setMetadata();
        setFeatures();
        setProducts();
    }

    public Map<String, Products> getProducts(){
        return products;
    }

    public void addFeatures(String id, Features feature) {
        features.put(id, feature);
    }

    public  void addCells(Cells c, String idProduct){
        products.get(idProduct).getCells().put(c.getFeatureId(), c);
    }

    private String notNull(String key) {
        Object obj;
        try {
            obj = json.get(key);
            if(obj ==null )
            { return "null"; }
            else { return  obj.toString(); }
        } catch (JSONException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public void setFeatures(){
        try {
            JSONArray feat = json.getJSONArray("features");
            for(int i = 0; i < feat.length(); i++) {
                String name = feat.getJSONObject(i).getString("name");
                String type = feat.getJSONObject(i).getString("type");
                String id = feat.getJSONObject(i).getString("id");
                Features feature = new Features(name, type, id);
                addFeatures(id,feature);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setProducts(){
        try{
            JSONArray productsJson = json.getJSONArray("products");
            for(int i = 0; i< productsJson.length(); i++){
                String id = productsJson.getJSONObject(i).getString("id");
                JSONArray cellsJson = productsJson.getJSONObject(i).getJSONArray("cells");
                cell = new LinkedHashMap<String, Cells>();
                Products product = new Products(id, cell);
                products.put(id, product);
                setCell(cellsJson, id);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setCell(JSONArray cellsJson, String id) {
        for (int y =0; y < cellsJson.length();y++) {
            JSONObject cellJson = cellsJson.getJSONObject(y);
            Object value;
            String type = cellJson.getString("type");
            String s;
            switch(type) {
                case "boolean" :
                    s = cellJson.getString("value");
                    boolean bool = Boolean.parseBoolean(s);
                    value = bool;
                    break;
                case "number" :
                    Double d = cellJson.getDouble("value");
                    if ((d == Math.floor(d)) && !Double.isInfinite(d)) {
                        Integer n = cellJson.getInt("value");
                        value = n;
                    }
                    else{
                        value = d;
                    }
                    break;
                case "undefined":
                    value = JSONObject.NULL;
                    break;

                default:
                    s = cellJson.getString("value");
                    value = s;
                    break;
            }
            String t = cellJson.getString("type");
            String unit = cellJson.getString("unit");
            Boolean isPartial = cellJson.getBoolean("isPartial");
            String featureId = cellJson.getString("featureId");
            c = new Cells(featureId, t, unit, value, isPartial);
            addCells(c, id);
        }
    }

    public JSONObject featureToJson(JSONObject j) {
        features.forEach((k,v) -> {
            j.accumulate("features", new JSONObject(features.get(k)));
        });
        return j;
    }

    public JSONObject productToJson(JSONObject j) {
        products.forEach((k,v) -> {
        JSONObject o = new JSONObject();
        o.put("id", k);
        v.getCells().forEach((k1, v1) -> o.accumulate("cells", new JSONObject(v1)));
        j.accumulate("products", o);
    });
        return j;
    }

    public Metadata getMetadata(){
        return metadata;
    }

    public void setMetadata() {
        try {
            Map<String, String> mapString = new HashMap<>();
            mapString.put("author", notNull("author"));
            mapString.put("source", notNull("source"));
            mapString.put("license", notNull("license"));
            mapString.put("name", notNull("name"));
            mapString.put("description", notNull("description"));
            mapString.put("primaryFeatureId", notNull("primaryFeatureId"));
            mapString.put("_id", notNull("_id"));

            Map<String, Integer> mapInt = new HashMap<>();
            mapInt.put("featureIdGen", json.getInt("featureIdGen"));
            mapInt.put("productIdGen", json.getInt("productIdGen"));
            metadata = new Metadata(mapString, mapInt);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

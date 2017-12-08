package PCM;

import com.sun.istack.internal.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Real;

public class PCM  {

    JSONObject json;
    Metadata metadata;
    Cells c;
    Map<String, Features> features;
    Map<String,Cells> cell;
    Map<String,Map> products;

    public PCM (Map<String, Features> features, Map<String,Map> products){
        this.features = features;
        this.products = products;
    }

    public Map<String, Map> getProducts(){
        return products;
    }

    public void addFeatures(String id, Features feature) {
        features.put(id, feature);
    }

    public void addProduct(String id){
        cell = new LinkedHashMap<String, Cells>();
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

    public void setProductsCells(){
        try{
            JSONArray productsJson = json.getJSONArray("products");
            for(int i = 0; i< productsJson.length(); i++){
                String id = productsJson.getJSONObject(i).getString("id");
                JSONArray cellsJson = productsJson.getJSONObject(i).getJSONArray("cells");
                addProduct(id);
                for (int y =0; y < cellsJson.length();y++) {
                    JSONObject cellJson = cellsJson.getJSONObject(y);
                    Object value;
                    String type = cellJson.getString("type");
                    String s ="";
                    if((type.equals("number") || type.equals("undefined")) || (type.equals("number") && type.equals("undefined") )) {
                    }else{
                        s = cellJson.getString("value");
                    }
                    switch(type) {
                        case "boolean" :
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(getProducts().get("P0").get("F0").toString());
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
            v.forEach((k1, v1) -> {
                o.accumulate("cells", new JSONObject(v1));
            });
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
            System.out.println("--------------------");
            System.out.println(metadata.toString());
            System.out.println("-----------------");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

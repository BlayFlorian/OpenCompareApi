package PCM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Real;

public class PCM  {

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
                for (int y =0; y < cellsJson.length();y++) {
                    JSONObject cellJson = cellsJson.getJSONObject(y);
                    c = new Cells();
                    String type = cellJson.getString("type");
                    String s ="";
                    if((type.equals("number") || type.equals("undefined")) || (type.equals("number") && type.equals("undefined") )) {
                    }else{
                        s = cellJson.getString("value");
                    }
                    switch(type) {
                        case "date":
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                            try {
                                Date d = sdf.parse(s);
                                c.setValue(d);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                           break;

                        case "string":
                            c.setValue(s);
                            break;

                        case "boolean" :
                            boolean bool = Boolean.parseBoolean(s);
                                c.setValue(bool);
                            break;
                        case "number" :
                            Double d = cellJson.getDouble("value");
                            if ((d == Math.floor(d)) && !Double.isInfinite(d)) {
                                Integer n = cellJson.getInt("value");
                                c.setValue(n);
                            }
                            else{
                                c.setValue(d);
                            }

                            break;
                        case "undefined":
                            c.setValue(null);

                        default:
                            c.setValue(s);

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
        System.out.println(getProducts().get("P0").get("F0").toString());
    }


}

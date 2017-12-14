package PCM;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.*;

/**
 * @author Lucile FLOC, Florian BLAY, Nicolas RANNOU, Briac PERRIN, Othmane WAFI
 * Classe qui gère la création du PCM
 */
public class PCM  {

    /**
     * Propriétés privées
     */
    JSONObject json;
    Metadata metadata;
    Cell c;
    LinkedHashMap<String, Feature> features;
    LinkedHashMap<String, Cell> cell;
    LinkedHashMap<String, Product> products;

    /**
     * Constructeur de la classe PCM
     * @param json
     */
    public PCM (JSONObject json){
        this.features = new LinkedHashMap<String, Feature>();
        this.products = new LinkedHashMap<String, Product>();
        this.json = json;
        setMetadata();
        setFeatures();
        setProducts();
    }

    /**
     * Getter
     * @return les products
     */
    public Map<String, Product> getProducts(){
        return products;
    }

    /**
     * Ajoute les features dans le nouveau PCM
     * @param id
     * @param feature
     */
    public void addFeatures(String id, Feature feature) {
        features.put(id, feature);
    }

    /**
     * Ajoute les cells dans le nouveau PCM
     * @param c
     * @param idProduct
     */
    public  void addCells(Cell c, String idProduct){
        products.get(idProduct).getCells().put(c.getFeatureId(), c);
    }

    /**
     * Gère si l'objet est null
     * @param key
     * @return le type de l'objet null ou string
     */
    private Object notNull(String key) {
        Object obj;
        try {
            obj = json.get(key);
            if(obj == JSONObject.NULL )
            {
                return JSONObject.NULL;
            }
            else { return  obj.toString(); }
        } catch (JSONException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    /**
     * Ajoute les features au PCM
     */
    public void setFeatures(){
        try {
            JSONArray feat = json.getJSONArray("features");
            for(int i = 0; i < feat.length(); i++) {
                String name = feat.getJSONObject(i).getString("name");
                String type = feat.getJSONObject(i).getString("type");
                String id = feat.getJSONObject(i).getString("id");
                Feature feature = new Feature(name, type, id);
                addFeatures(id,feature);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ajoute les products au PCM
     */
    public void setProducts(){
        try{
            JSONArray productsJson = json.getJSONArray("products");
            for(int i = 0; i< productsJson.length(); i++){
                String id = productsJson.getJSONObject(i).getString("id");
                JSONArray cellsJson = productsJson.getJSONObject(i).getJSONArray("cells");
                cell = new LinkedHashMap<String, Cell>();
                Product product = new Product(id, cell);
                products.put(id, product);
                setCell(cellsJson, id);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ajoute les cellules au PCM et gère le type
     * @param cellsJson
     * @param id
     */
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
                    if(cellJson.getString("value") == JSONObject.NULL) {
                        value = JSONObject.NULL;
                    } else {
                        value = cellJson.getString("value");
                    }
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
            c = new Cell(featureId, t, unit, value, isPartial);
            addCells(c, id);
        }
    }

    /**
     * Transforme l'objet feature en JSON
     * @param j
     * @return l'objet json
     */
    public JSONObject featureToJson(JSONObject j) {
        if(features.size() > 1) {
            features.forEach((k,v) -> {
                j.accumulate("features", new JSONObject(features.get(k)));
            });
        }
        return j;
    }

    /**
     * Transforme l'objet product en JSON
     * @param j
     * @return l'objet json
     */
    public JSONObject productToJson(JSONObject j) {
        products.forEach((k,v) -> {
        JSONObject o = new JSONObject();
        o.put("id", k);
        v.getCells().forEach((k1, v1) -> o.accumulate("cells", new JSONObject(v1)));
        j.accumulate("products", o);
    });
        return j;
    }

    /**
     * Getter
     * @return metadata
     */
    public Metadata getMetadata(){
        return metadata;
    }

    /**
     * Ajoute les metadata au PCM
     */
    public void setMetadata() {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("author", notNull("author"));
            map.put("source", notNull("source"));
            map.put("license", notNull("license"));
            map.put("name", notNull("name"));
            map.put("description", notNull("description"));
            map.put("primaryFeatureId", notNull("primaryFeatureId"));
            map.put("_id", notNull("_id"));

            map.put("featureIdGen", json.getInt("featureIdGen"));
            map.put("productIdGen", json.getInt("productIdGen"));
            metadata = new Metadata(map);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

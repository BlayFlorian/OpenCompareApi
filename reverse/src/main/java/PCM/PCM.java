package PCM;

import java.util.HashMap;
import java.util.Map;

public class PCM {
    String author;
    String source;
    String description;
    String licence;
    String name;
    int featureIdGen;
    String primaryFeatureId;
    int productIdGen;
    String _id;
    Map<String, Features> features;
    Map<String,Cells> cell;
    Map<String,Map> products;

    public PCM (String author, String source, String description, String licence, String name,int featureIdGen,String primaryFeatureId,int productIdGen,String _id){
        this.author = author;
        this.source = source;
        this.description = description;
        this.licence = licence;
        this.name = name;
        this.featureIdGen = featureIdGen;
        this.primaryFeatureId = primaryFeatureId;
        this.productIdGen = productIdGen;
        this._id = _id;
        features = new HashMap<String, Features>();
        products = new HashMap<String,Map>();
    }

    public Map<String, Map> getProducts(){
        return products;
    }

    public void setFeatures(String id, String name, String type) {
        Features feature= new Features(name, type);
        features.put(id, feature);
    }

    public void setProduct(String id){
        cell = new HashMap<String, Cells>();
        products.put(id, cell);
    }

    public  void setCells(String featureId,String type,String unit,String value, String idProduct){
        Cells c = new Cells(type,unit, value);
        products.get(idProduct).put(featureId, c);
    }

    @Override
    public String toString() {
        return "author: "+ author + " Name: " +name + " Source: "+ source + " Description: " + description + " Licence: " + licence;
    }
}

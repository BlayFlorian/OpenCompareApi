package PCM;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class Metadata {

    private String author;
    private String source;
    private String description;
    private String license;
    private String name;
    private int featureIdGen;
    private String primaryFeatureId;
    private int productIdGen;
    private String _id;

    public Metadata(Map<String, String> metadataString, Map<String, Integer> metadataInt){

        this.author = metadataString.get("author");
        this.source = metadataString.get("source");
        this.description = metadataString.get("description");
        this.license = metadataString.get("license");
        this.name = metadataString.get("name");
        this.featureIdGen = metadataInt.get("featureIdGen");
        this.primaryFeatureId = metadataString.get("primaryFeatureId");
        this.productIdGen = metadataInt.get("productIdGen");
        this._id = metadataString.get("_id");

    }

    public String getAuthor() {
        return author;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public String getLicense() {
        return license;
    }

    public String getName() {
        return name;
    }

    public int getFeatureIdGen() {
        return featureIdGen;
    }

    public String getPrimaryFeatureId() {
        return primaryFeatureId;
    }

    public int getProductIdGen() {
        return productIdGen;
    }

    public String get_id() {
        return _id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLicence(String license) {
        this.license = license;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFeatureIdGen(int featureIdGen) {
        this.featureIdGen = featureIdGen;
    }

    public void setPrimaryFeatureId(String primaryFeatureId) {
        this.primaryFeatureId = primaryFeatureId;
    }

    public void setProductIdGen(int productIdGen) {
        this.productIdGen = productIdGen;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "id " + _id + " author: "+ author + " Name: " +name + " Source: "+ source + " Description: " + description + " Licence: " + license;
    }

    public JSONObject toJson() {
        JSONObject o = new JSONObject(this);
        o.put("_id", _id);
        System.out.println(o.toString());
        return o;
    }
}

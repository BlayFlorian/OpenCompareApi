package PCM;

import org.json.JSONObject;

import java.util.Map;

public class Metadata {

    private Object author;
    private Object source;
    private Object description;
    private Object license;
    private Object name;
    private Object featureIdGen;
    private Object primaryFeatureId;
    private Object productIdGen;
    private Object _id;

    public Metadata(Map<String, Object> metadata){

        this.author = metadata.get("author");
        this.source = metadata.get("source");
        this.description = metadata.get("description");
        this.license = metadata.get("license");
        this.name = metadata.get("name");
        this.featureIdGen = metadata.get("featureIdGen");
        this.primaryFeatureId = metadata.get("primaryFeatureId");
        this.productIdGen = metadata.get("productIdGen");
        this._id = metadata.get("_id");

    }

    public Object getAuthor() {
        return author;
    }

    public Object getSource() {
        return source;
    }

    public Object getDescription() {
        return description;
    }

    public Object getLicense() {
        return license;
    }

    public Object getName() {
        return name;
    }

    public Object getFeatureIdGen() {
        return featureIdGen;
    }

    public Object getPrimaryFeatureId() {
        return primaryFeatureId;
    }

    public Object getProductIdGen() {
        return productIdGen;
    }

    public Object get_id() {
        return _id;
    }

    public void setAuthor(Object author) {
        this.author = author;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public void setLicence(Object license) {
        this.license = license;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public void setFeatureIdGen(Object featureIdGen) {
        this.featureIdGen = featureIdGen;
    }

    public void setPrimaryFeatureId(Object primaryFeatureId) {
        this.primaryFeatureId = primaryFeatureId;
    }

    public void setProductIdGen(Object productIdGen) {
        this.productIdGen = productIdGen;
    }

    public void set_id(Object _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "id " + _id + " author: "+ author + " Name: " +name + " Source: "+ source + " Description: " + description + " Licence: " + license;
    }

    public JSONObject toJson() {
        JSONObject o = new JSONObject(this);
        o.put("_id", _id);
        return o;
    }
}

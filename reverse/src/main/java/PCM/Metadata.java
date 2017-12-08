package PCM;

import org.json.JSONException;
import org.json.JSONObject;

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

    public Metadata(){

    }
    public Metadata(String author, String source, String description, String licence,String name,int featureIdGen,String primaryFeatureId, int productIdGen, String _id){
        this.author = author;
        this.source = source;
        this.description = description;
        this.license = licence;
        this.name = name;
        this.featureIdGen = featureIdGen;
        this.primaryFeatureId = primaryFeatureId;
        this.productIdGen = productIdGen;
        this._id = _id;

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
        return "author: "+ author + " Name: " +name + " Source: "+ source + " Description: " + description + " Licence: " + license;
    }

    public JSONObject toJson() {
        return new JSONObject(this);
    }
}

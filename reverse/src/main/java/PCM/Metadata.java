package PCM;

import org.json.JSONObject;

import java.util.Map;

/**
 * @author Lucile FLOC, Florian BLAY, Nicolas RANNOU, Briac PERRIN, Othmane WAFI
 * Classe qui gère les metadata du PCM
 */
public class Metadata {

    /**
     * Propriétés privées
     */
    private Object author;
    private Object source;
    private Object description;
    private Object license;
    private Object name;
    private Object featureIdGen;
    private Object primaryFeatureId;
    private Object productIdGen;
    private Object _id;

    /**
     * Constructeur de la classe Metadata
     * @param metadata
     */
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

    /**
     * Getter
     * @return l'auteur
     */
    public Object getAuthor() {
        return author;
    }

    /**
     * Getter
     * @return la source
     */
    public Object getSource() {
        return source;
    }

    /**
     * Getter
     * @return la description
     */
    public Object getDescription() {
        return description;
    }

    /**
     * Getter
     * @return la licence
     */
    public Object getLicense() {
        return license;
    }

    /**
     * Getter
     * @return le nom
     */
    public Object getName() {
        return name;
    }

    /**
     * Getter
     * @return featureIdGen
     */
    public Object getFeatureIdGen() {
        return featureIdGen;
    }

    /**
     * Getter
     * @return primaryFeatureId
     */
    public Object getPrimaryFeatureId() {
        return primaryFeatureId;
    }

    /**
     * Getter
     * @return productIdGen
     */
    public Object getProductIdGen() {
        return productIdGen;
    }

    /**
     * Setter qui modifie l'auteur
     * @param author
     */
    public void setAuthor(Object author) {
        this.author = author;
    }

    /**
     * Setter qui modifie la source
     * @param source
     */
    public void setSource(Object source) {
        this.source = source;
    }

    /**
     * Setter qui modifie la description
     * @param description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     * Setter qui modifie la licence
     * @param license
     */
    public void setLicence(Object license) {
        this.license = license;
    }

    /**
     * Setter qui modifie le nom
     * @param name
     */
    public void setName(Object name) {
        this.name = name;
    }

    /**
     * Setter qui modifie featureIdGen
     * @param featureIdGen
     */
    public void setFeatureIdGen(Object featureIdGen) {
        this.featureIdGen = featureIdGen;
    }

    /**
     * Setter qui modifie primaryFeatureId
     * @param primaryFeatureId
     */
    public void setPrimaryFeatureId(Object primaryFeatureId) {
        this.primaryFeatureId = primaryFeatureId;
    }

    /**
     * Setter qui modifie productIdGen
     * @param productIdGen
     */
    public void setProductIdGen(Object productIdGen) {
        this.productIdGen = productIdGen;
    }

    /**
     * Setter qui modifie l'id
     * @param _id
     */
    public void set_id(Object _id) {
        this._id = _id;
    }

    /**
     * Transforme this en JSON
     * @return l'objet json
     */
    public JSONObject toJson() {
        JSONObject o = new JSONObject(this);
        o.put("_id", _id);
        return o;
    }
}

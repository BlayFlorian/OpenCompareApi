package PCM;

/**
 * @author Lucile FLOC, Florian BLAY, Nicolas RANNOU, Briac PERRIN, Othmane WAFI
 * Classe qui gère les cellules qui se trouvent dans les products
 */
public class Cell {

    /**
     * Propriétés privées
     */
    private String featureId;
    private String type ;
    private String unit;
    private Object value;
    private boolean isPartial;

    /**
     * Constructeur de la classe Cell
     * @param featureId
     * @param type
     * @param unit
     * @param value
     * @param isPartial
     */
    public Cell(String featureId, String type, String unit, Object value, Boolean isPartial){
        this.featureId = featureId;
        this.value = value;
        this.type =type;
        this.unit = unit;
        this.isPartial = isPartial;
    }

    /**
     * Getter
     * @return l'id du feature de la cellule
     */
    public String getFeatureId() {
        return featureId;
    }

    /**
     * Getter
     * @return le type de la cellule
     */
    public String getType() {
        return type;
    }

    /**
     * Getter
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Getter
     * @return la valeur de la cellule
     */
    public Object getValue() {
        return value;
    }

    /**
     * Getter
     * @return un booléen isPartial
     */
    public Boolean getIsPartial() {
        return isPartial;
    }

}
